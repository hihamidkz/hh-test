package com.example;

import com.example.hhapi.HeadHunterApiService;
import com.example.hhapi.HeadHunterApiServiceImpl;

import com.example.myservice.model.Vacancy;
import com.example.myservice.service.VacancyLocalServiceUtil;
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
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.io.IOException;
import java.util.List;

import de.steinwedel.messagebox.MessageBox;

@Theme("mytheme")
@SuppressWarnings("serial")
@Widgetset("com.example.AppWidgetSet")
public class MyPortletUI extends UI {

    private static Log log = LogFactoryUtil.getLog(MyPortletUI.class);
    private HeadHunterApiService service;
    private String searchText = "";
    private String errorMsg = "";
    
    private int page = 1;
    private int limit = 20;
    private int pagesCount = 0;
    
    private Table table;
    private Pagination pagination;
    
    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
        service = new HeadHunterApiServiceImpl();
        
        List<Vacancy> vacancies = null;
        try {
            vacancies = service.getVacancies(page, limit);
        } catch (SystemException | IOException e) {
            e.printStackTrace();
        }
        
        pagesCount = service.getPagesCount(limit);
        
        if (pagesCount == -1) {
            showErrorMsg("Ошибка сети", errorMsg);
            pagesCount = 1;
        }
        
        final long total = limit * pagesCount;
        
        table = createTable(vacancies);
        pagination = createPagination(total, page, limit);
        pagination.addPageChangeListener((PaginationResource event)-> {
            limit = event.limit();
            page = event.page();
            fillTable();
        });
        
        final TextField textField = new TextField();
        textField.setWidth(30, Unit.REM);
        final Button button = new Button("Найти");
        final Button reset = new Button("Сброс");
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
        
        layout.addComponent(searchLayout);
        layout.addComponent(table);
        layout.addComponent(pagination);
        layout.setSpacing(true);
    }
    
    private void fillTable() {
        table.removeAllItems();
        List<Vacancy> vacancyList = null;
        if (searchText.equals("")) {
            vacancyList  = getVacancies(page, limit);
        } else {
            vacancyList = searchVacancies(page, limit);
        }
        if (vacancyList == null) {
            return;
        }
        for (Vacancy v : vacancyList) {
            table.addItem(v);
        }
    }
    
    private List<Vacancy> getVacancies(int page, int perPage) {
        List<Vacancy> vacancies = null;
        
        try {
            int start = page * perPage;
            int end = start + perPage;
            vacancies = VacancyLocalServiceUtil.getVacancies(start, end);
        } catch (SystemException e1) {
            showErrorMsg("Ошибка", e1.getMessage());
            e1.printStackTrace();
        }
        
        if (vacancies.isEmpty()) {
            try {
                vacancies = service.getVacancies(page - 1, perPage);
            } catch (IOException | SystemException e2) {
                showErrorMsg("Ошибка", e2.getMessage());
                e2.printStackTrace();
            }
        }
        
        if (vacancies == null) {
            errorMsg = service.getErrorMsg();
            showErrorMsg("Ошибка сети", errorMsg);
        }
        
        return vacancies;
    }
    
    private List<Vacancy> searchVacancies(int page, int perPage) {
        List<Vacancy> vacancies = null;
        
        try {
            vacancies = service.searchVacancies(page - 1, perPage, searchText);
        } catch (IOException | SystemException e2) {
            showErrorMsg("Ошибка", e2.getMessage());
            e2.printStackTrace();
        }
        
        if (vacancies == null) {
            errorMsg = service.getErrorMsg();
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
