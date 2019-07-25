package com.example.hhapi;

import com.example.model.Address;
import com.example.model.Employer;
import com.example.model.Salary;
import com.example.model.Vacancy;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class JSONParserImpl implements JSONParser {
    @Override
    public List<Vacancy> parseVacancies(String json) {
        JsonParser parser = new JsonParser();
        JsonObject object = parser.parse(json).getAsJsonObject();
        JsonArray array = object.getAsJsonArray("items");

        List<Vacancy> vacancies = new ArrayList<>();

        for (JsonElement e : array) {
            JsonObject o = e.getAsJsonObject();
            long id = o.get("id").getAsLong();
            String name = o.get("name").getAsString();
            String publishedAt = o.get("published_at").getAsString();
            Employer employer = parseEmployeer(o.get("employer"));
            Salary salary = parseSalary(o.get("salary"));
            Address address = parseAddress(o.get("address"));
            Vacancy vacancy = new Vacancy(id, name, publishedAt, employer, salary, address);
            vacancies.add(vacancy);
        }

        return vacancies;
    }

    private Employer parseEmployeer(JsonElement element) {
        if (element.isJsonNull()) {
            return null;
        }

        JsonObject object = element.getAsJsonObject();
        long id = object.get("id").getAsLong();
        String employerName = object.get("name").getAsString();
        String website = object.get("url").getAsString();

        Employer employer = new Employer(id, employerName, website);

        return employer;
    }

    private Salary parseSalary(JsonElement element) {
        if (element.isJsonNull()) {
            return null;
        }

        JsonObject object = element.getAsJsonObject();
        String from = object.get("from").getAsString();
        String to = "";

        if (!object.get("to").isJsonNull()) {
            to = object.get("to").getAsString();
        }

        Salary salary = new Salary(from, to);

        return salary;
    }

    private Address parseAddress(JsonElement element) {
        if (element.isJsonNull()) {
            return null;
        }

        JsonObject object = element.getAsJsonObject();
        String city = object.get("city").getAsString();
        String street = object.get("street").getAsString();
        String building = object.get("building").getAsString();

        Address address = new Address(city, street, building);

        return address;
    }
}
