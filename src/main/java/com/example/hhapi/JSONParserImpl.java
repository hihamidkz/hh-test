package com.example.hhapi;

import com.example.myservice.model.Vacancy;

import com.example.myservice.service.VacancyLocalServiceUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JSONParserImpl implements JSONParser {
    @Override
    public List<Vacancy> parseVacancies(String json) throws SystemException {
        JsonParser parser = new JsonParser();
        JsonObject object = parser.parse(json).getAsJsonObject();
        JsonArray array = object.getAsJsonArray("items");

        List<Vacancy> vacancies = new ArrayList<>();

        for (JsonElement e : array) {
            JsonObject o = e.getAsJsonObject();
            long id = o.get("id").getAsLong();
            String name = o.get("name").getAsString();
            String publishedAt = o.get("published_at").getAsString();
            String employer = parseEmployeer(o.get("employer"));
            String salary = parseSalary(o.get("salary"));
            String address = parseAddress(o.get("address"));
            Vacancy vacancy = VacancyLocalServiceUtil.createVacancy(id);
            vacancy.setName(name);
            vacancy.setPublishedAt(publishedAt);
            vacancy.setSalary(salary);
            vacancy.setEmployer(employer);
            vacancy.setAddress(address);
            vacancies.add(vacancy);
            VacancyLocalServiceUtil.addOrUpdate(vacancy);
        }

        return vacancies;
    }

    private String parseEmployeer(JsonElement element) throws SystemException {
        if (element.isJsonNull()) {
            return null;
        }

        JsonObject object = element.getAsJsonObject();
        String employer = object.get("name").getAsString();

        return employer;
    }

    private String parseSalary(JsonElement element) {
        if (element.isJsonNull()) {
            return null;
        }

        JsonObject object = element.getAsJsonObject();
        String from = object.get("from").getAsString();
        String to = null;

        if (!object.get("to").isJsonNull()) {
            to = object.get("to").getAsString();
        }

        String salary = (to == null) ? 
                "От " + from : "От " + from + " до " + to;

        return salary;
    }

    private String parseAddress(JsonElement element) throws SystemException {
        if (element.isJsonNull()) {
            return null;
        }

        JsonObject object = element.getAsJsonObject();
        String city = object.get("city").getAsString();
        String street = object.get("street").getAsString();
        String building = object.get("building").getAsString();
        String address = city + ", " + street + ", " + building;
        
        return address;
    }
}
