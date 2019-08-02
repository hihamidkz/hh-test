package com.example;

import com.example.hhapi.service.HeadHunterApiService;
import com.example.hhapi.service.HeadHunterApiServiceImpl;
import com.example.myservice.model.Locality;
import com.example.myservice.model.Region;
import com.example.myservice.model.Vacancy;

import com.example.myservice.service.RegionLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vaadin.addon.pagination.Pagination;
import com.vaadin.addon.pagination.PaginationResource;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.steinwedel.messagebox.MessageBox;

import java.io.IOException;
import java.util.List;

@Theme("mytheme")
@SuppressWarnings("serial")
@Widgetset("com.example.AppWidgetSet")
public class MyPortletUI extends UI {
    
    private HeadHunterApiService service;
    private String searchText = "";
    private String errorMsg = "";
    private String area = "";
    
    private int page = 1;
    private int limit = 20;
    private int pagesCount = 0;
    
    private Table table;
    private Pagination pagination;
    
    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setMargin(true);
        setContent(mainLayout);
        
        service = new HeadHunterApiServiceImpl();
        
        List<Vacancy> vacancies = getVacancies(page, limit);
        
        final long total = limit * pagesCount;
        
        table = createTable(vacancies);
        pagination = createPagination(total, page, limit);
        pagination.addPageChangeListener((PaginationResource event)-> {
            limit = event.limit();
            page = event.page();
            pagination.setTotalCount(pagesCount * limit);
            fillTable();
        });
        
        final TextField textField = new TextField();
        textField.setWidth(30, Unit.REM);
        final Button button = new Button("Найти");
        final Button reset = new Button("Сбросить параметры поиска");
        final HorizontalLayout searchLayout = new HorizontalLayout();
        searchLayout.setSpacing(true);
        searchLayout.addComponent(textField);
        searchLayout.addComponent(button);
        searchLayout.addComponent(reset);

        button.addClickListener((ClickEvent event)-> {
            searchText = textField.getValue();
            if (page == 1) {
                fillTable();
            } else {
                pagination.setCurrentPage(1);
            }
        });
        
        reset.addClickListener((ClickEvent event)-> {
            textField.setValue("");
            searchText = "";
            if (page == 1) {
                fillTable();
            } else {
                pagination.setCurrentPage(1);
            }
        });
        
        final ComboBox localities = new ComboBox("Населенные пункты");
        final ComboBox regions = getRegionsComboBox(localities);
        final Button resetFilters = new Button("Сбросить фильтр");
        final HorizontalLayout areaLayout = new HorizontalLayout();
        areaLayout.addComponent(regions);
        areaLayout.addComponent(localities);
        areaLayout.addComponent(resetFilters);
        areaLayout.setSpacing(true);
        areaLayout.setComponentAlignment(resetFilters, Alignment.BOTTOM_RIGHT);
        
        localities.setNullSelectionAllowed(false);
        localities.addValueChangeListener(event-> {
            if (localities.getValue() == null) {
                area = regions.getValue().toString();
            } else {
                area = localities.getValue().toString();;
            }
            if (page == 1) {
                fillTable();
            } else {
                pagination.setCurrentPage(1);
            }
        });
        
        resetFilters.addClickListener(event-> {
            localities.setValue("");
            regions.setValue("");
            area = "";
            if (page == 1) {
                fillTable();
            } else {
                pagination.setCurrentPage(1);
            }
        });
        
        mainLayout.addComponent(searchLayout);
        mainLayout.addComponent(areaLayout);
        mainLayout.addComponent(table);
        mainLayout.addComponent(pagination);
        mainLayout.setSpacing(true);
    }
    
    /**
     * Creates new ComboBox for choosing areas
     */
    private ComboBox getRegionsComboBox(ComboBox localitiesComboBox) {
        List<Region> areas = getRegions();
        
        ComboBox select = new ComboBox("Регионы");
        select.setNullSelectionAllowed(false);
        if (areas != null) {
            for (Region r : areas) {
                select.addItem(r.getName());
            }
        }
        
        select.addValueChangeListener(event-> {
            area = select.getValue().toString();
            if (page == 1) {
                fillTable();
            } else {
                pagination.setCurrentPage(1);
            }
            try {
                List<Region> regions = RegionLocalServiceUtil.getRegionForName(
                        select.getValue().toString());
                Region region = regions.get(0);
                localitiesComboBox.removeAllItems();
                List<Locality> localities = region.getLocalities();
                for (Locality l : localities) {
                    localitiesComboBox.addItem(l.getName());
                }
            } catch (SystemException e) {
                showErrorMsg("Ошибка", e.getMessage());
                e.printStackTrace();
            }
        });
        return select;
    }
    
    /**
     * Gets areas via hh-api or from database 
     * @return list of areas
     */
    private List<Region> getRegions() {
        List<Region> areas = null;
        
        try {
            int count = RegionLocalServiceUtil.getRegionsCount();
            if (count != 0) {
                areas = RegionLocalServiceUtil.getRegions(0, count);
            }
        } catch (SystemException e) {
            showErrorMsg("Ошибка", e.getMessage());
            e.printStackTrace();
        }
        
        if (areas == null) {
            try {
                areas = service.getAreas();
            } catch(IOException | SystemException e) {
                showErrorMsg("Ошибка", e.getMessage());
                e.printStackTrace();
            }
        }
        
        return areas;
    }
    
    /**
     * Fills table with vacancies entries
     */
    private void fillTable() {
        table.removeAllItems();
        List<Vacancy> vacancyList = null;
        if (searchText.equals("") && area.equals("")) {
            vacancyList  = getVacancies(page, limit);
        } else if (area.equals("")) {
            vacancyList = searchVacancies(page, limit);
        } else {
            vacancyList = searchVacanciesForArea(page, limit);
        }
        if (vacancyList == null) {
            return;
        }
        
        pagination.setTotalCount(pagesCount * limit);
        for (Vacancy v : vacancyList) {
            table.addItem(v);
        }
    }
    
    /**
     * Gets all vacancies
     */
    private List<Vacancy> getVacancies(int page, int perPage) {
        List<Vacancy> vacancies = null;
        
        try {
            vacancies = service.getVacancies(page - 1, perPage);
        } catch (IOException | SystemException e2) {
            showErrorMsg("Ошибка", e2.getMessage());
            e2.printStackTrace();
        }
        
        pagesCount = service.getPagesCount(perPage);
        
        if (pagesCount == -1) {
            pagesCount = 1;
            errorMsg = service.getErrorMsg();
            showErrorMsg("Ошибка сети", errorMsg);
        }
        
        return vacancies;
    }
    
    /**
     * Finds and gets all vacancies with specified text
     */
    private List<Vacancy> searchVacancies(int page, int perPage) {
        List<Vacancy> vacancies = null;
        
        try {
            vacancies = service.searchVacancies(page - 1, perPage, searchText);
        } catch (IOException | SystemException e2) {
            showErrorMsg("Ошибка", e2.getMessage());
            e2.printStackTrace();
        }
        
        pagesCount = service.getPagesCount(perPage);
        
        if (pagesCount == -1) {
            errorMsg = service.getErrorMsg();
            pagesCount = 1;
            showErrorMsg("Ошибка сети", errorMsg);
        }
        
        return vacancies;
    }
    
    /**
     * Finds and gets all vacancies for specified area
     */
    private List<Vacancy> searchVacanciesForArea(int page, int perPage) {
        List<Vacancy> vacancies = null;
        
        try {
            vacancies = service.searchVacanciesForArea(page - 1, perPage,
                                                       area, searchText);
        } catch (IOException | SystemException e2) {
            showErrorMsg("Ошибка", e2.getMessage());
            e2.printStackTrace();
        }
        
        pagesCount = service.getPagesCount(perPage);
        
        if (pagesCount == -1) {
            errorMsg = service.getErrorMsg();
            pagesCount = 1;
            showErrorMsg("Ошибка сети", errorMsg);
        }
        
        return vacancies;
    }
    
    private Table createTable(List<Vacancy> vacancies) {
        final Table table = new Table();
        table.setSizeFull();
        table.setContainerDataSource(new BeanItemContainer<>(Vacancy.class, 
                                                             vacancies));
        table.setVisibleColumns("name", "employer", "salary", "address");
        table.setColumnHeaders("Название", "Организация", "Зарплата", "Адрес");
        return table;
    }
    
    private Pagination createPagination(long total, int page, int limit) {
        final PaginationResource paginationResource = 
                PaginationResource.newBuilder()
                                  .setTotal(total)
                                  .setPage(page)
                                  .setLimit(limit)
                                  .build();
        final Pagination pagination = new Pagination(paginationResource);
        pagination.setItemsPerPage(10, 20, 50, 100);
        return pagination;
    }
    
    private void showErrorMsg(String title, String msg) {
        MessageBox.createError()
                  .withCaption(title)
                  .withMessage(msg)
                  .withOkButton()
                  .open();
    }
}
