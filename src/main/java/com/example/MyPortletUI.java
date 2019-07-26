package com.example;

import com.example.hhapi.HeadHunterApi;
import com.example.hhapi.HeadHunterApiServiceImpl;
import com.example.hhapi.JSONParser;
import com.example.hhapi.JSONParserImpl;

import com.example.myservice.model.Vacancy;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Theme("mytheme")
@SuppressWarnings("serial")
@Widgetset("com.example.AppWidgetSet")
public class MyPortletUI extends UI {

    private static Log log = LogFactoryUtil.getLog(MyPortletUI.class);

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        List<Vacancy> vacancies = null;
        
        HeadHunterApiServiceImpl service = new HeadHunterApiServiceImpl();
        try {
             vacancies = service.getAllVacancies();
        } catch (IOException | SystemException e) {
            log.error(e.getMessage());
        }
        
        /*for (Vacancy v : vacancies) {
            final VerticalLayout newLayout = new VerticalLayout();
            newLayout.addComponent(new Label(
                    v.getName(),
                    ContentMode.HTML));
            newLayout.addComponent(new Label(
                    v.getEmployer(),
                    ContentMode.HTML));
            newLayout.addComponent(new Label(
                    v.getAddress(),
                    ContentMode.HTML));
            newLayout.addComponent(new Label(
                    v.getSalary(),
                    ContentMode.HTML));
            layout.addComponent(newLayout);
        }*/
        
        final TextField textField = new TextField();
        textField.setWidth(30, Unit.REM);
        final Button button = new Button("Найти");

        button.addClickListener((ClickEvent event)-> {
            try {
                service.searchVacancies("text");
            } catch (SystemException | IOException e) {
                e.printStackTrace();
            }
        });
        layout.addComponent(textField);
        layout.addComponent(button);
    }
}
