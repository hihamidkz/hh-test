package com.example;

import com.example.hhapi.HeadHunterApiService;
import com.example.hhapi.HeadHunterApiServiceImpl;

import com.example.myservice.model.Vacancy;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.vaadin.addon.pagination.Pagination;
import com.vaadin.addon.pagination.PaginationResource;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
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
    private static HeadHunterApiService service;
    private static String searchText = "";
    private static String errorMsg = "";

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        int pagesCount = 0;
        
        final int page = 1;
        final int limit = 20;
        
        service = new HeadHunterApiServiceImpl();
        List<Vacancy> vacancies = getVacancies(page, limit);
        try {
             pagesCount = service.getPagesCount(limit);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        
        if (pagesCount == -1) {
            showErrorMsg("Ошибка сети", errorMsg);
            pagesCount = 1;
        }
        
        final long total = limit * pagesCount;
        
        final Table table = createTable(vacancies);
        final Pagination pagination = createPagination(total, page, limit);
        pagination.addPageChangeListener((PaginationResource event)-> {
            table.removeAllItems();
            final List<Vacancy> vacancyList = getVacancies(event.page(), event.limit());
            if (vacancyList == null) {
                return;
            }
            for (Vacancy v : vacancyList) {
                table.addItem(v);
            }
        });
        
        final TextField textField = new TextField();
        textField.setWidth(30, Unit.REM);
        final Button button = new Button("Найти");
        final HorizontalLayout searchLayout = new HorizontalLayout();
        searchLayout.addComponent(textField);
        searchLayout.addComponent(button);

        button.addClickListener((ClickEvent event)-> {
            System.out.println("clicked");
            try {
                service.searchVacancies(textField.getData().toString());
                log.debug(textField.getData().toString());
            } catch (SystemException | IOException e) {
                e.printStackTrace();
            }
        });
        
        layout.addComponent(searchLayout);
        layout.addComponent(table);
        layout.addComponent(pagination);
    }
    
    private List<Vacancy> getVacancies(int page, int perPage) {
        List<Vacancy> vacancies = null;
        
        try {
            vacancies = service.getVacancies(page, perPage);
        } catch (IOException | SystemException e) {
            showErrorMsg("Ошибка", e.getMessage());
            e.printStackTrace();
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
