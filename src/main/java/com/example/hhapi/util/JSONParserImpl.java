package com.example.hhapi.util;

import com.example.myservice.model.Locality;
import com.example.myservice.model.Region;
import com.example.myservice.model.Vacancy;
import com.example.myservice.service.LocalityLocalServiceUtil;
import com.example.myservice.service.RegionLocalServiceUtil;
import com.example.myservice.service.VacancyLocalServiceUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.Comparator;
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
    
    @Override
    public int parsePagesCount(String json) {
        JsonParser parser = new JsonParser();
        JsonObject object = parser.parse(json).getAsJsonObject();
        JsonElement pagesCount = object.get("pages");
        
        return pagesCount.getAsInt();
    }
    
    @Override
    public List<Region> parseRegions(String json) throws SystemException {
        JsonParser parser = new JsonParser();
        JsonArray ar = parser.parse(json).getAsJsonArray();
        JsonObject object = ar.get(0).getAsJsonObject();
        JsonArray array = object.get("areas").getAsJsonArray();
        
        List<Region> regions = new ArrayList<>();
        for (JsonElement e : array) {
            JsonObject obj = e.getAsJsonObject();
            Region r = parseRegion(obj);
            JsonArray arr = obj.get("areas").getAsJsonArray();
            for (JsonElement el : arr) {
                JsonObject o = el.getAsJsonObject();
                Locality l = parseLocality(o);
                LocalityLocalServiceUtil.addOrUpdate(l);
            }
            regions.add(r);
            RegionLocalServiceUtil.addOrUpdate(r);
        }
        regions.sort(new Comparator<Region>() {
            public int compare(Region r1, Region r2) {
                return r1.getName().compareTo(r2.getName());
            }
        });
        
        return regions;
    }

    private String parseEmployeer(JsonElement element) {
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
        StringBuilder salary = new StringBuilder();
        
        if (!object.get("from").isJsonNull()) {
            salary.append("от " + object.get("from").getAsString() + " ");
        }
        
        if (!object.get("to").isJsonNull()) {
            salary.append("до " + object.get("to").getAsString());
        }

        return salary.toString();
    }

    private String parseAddress(JsonElement element) {
        if (element.isJsonNull()) {
            return null;
        }

        JsonObject object = element.getAsJsonObject();
        StringBuilder address = new StringBuilder();
        
        if (!object.get("city").isJsonNull()) {
            address.append(object.get("city").getAsString() + " ");
        }
        
        if (!object.get("street").isJsonNull()) {
            address.append(object.get("street").getAsString() + ", ");
        }
        
        if (!object.get("building").isJsonNull()) {
            address.append(object.get("building").getAsString());
        }
        
        return address.toString();
    }
    
    private Region parseRegion(JsonObject obj) {
        int id = obj.get("id").getAsInt();
        int parentId = obj.get("parent_id").getAsInt();
        String name = obj.get("name").getAsString();
        Region r = RegionLocalServiceUtil.createRegion(id);
        r.setName(name);
        r.setParentId(parentId);
        
        return r;
    }
    
    private Locality parseLocality(JsonObject obj) {
        int localityId = obj.get("id").getAsInt();
        int localityParentId = obj.get("parent_id").getAsInt();
        String localityName = obj.get("name").getAsString();
        Locality l = LocalityLocalServiceUtil.createLocality(localityId);
        l.setName(localityName);
        l.setParentId(localityParentId);
        
        return l;
    }
}
