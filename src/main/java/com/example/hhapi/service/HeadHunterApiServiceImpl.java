package com.example.hhapi.service;

import com.example.hhapi.HeadHunterApi;
import com.example.hhapi.util.JSONParser;
import com.example.hhapi.util.JSONParserImpl;
import com.example.myservice.model.Locality;
import com.example.myservice.model.Region;
import com.example.myservice.model.Vacancy;
import com.example.myservice.service.LocalityLocalServiceUtil;
import com.example.myservice.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeadHunterApiServiceImpl implements HeadHunterApiService {

    @Override
    public List<Vacancy> getVacancies(int page, int perPage)
            throws IOException, SystemException {
        final JSONParser parser = new JSONParserImpl();
        final HeadHunterApi api = HeadHunterApi.getInstance(parser);
        
        return api.getVacancies(page, perPage);
    }

    @Override
    public List<Vacancy> searchVacancies(int page, int perPage, String text)
            throws IOException, SystemException {
        final JSONParser parser = new JSONParserImpl();
        final HeadHunterApi api = HeadHunterApi.getInstance(parser);
        
        String searchText = Arrays.stream(text.split(" "))
                                  .collect(Collectors.joining("+"));
        
        return api.getVacancies(page, perPage, searchText);
    }
    
    @Override
    public List<Vacancy> searchVacanciesForArea(int page,
                                                int perPage,
                                                String area,
                                                String text)
                      throws IOException, SystemException {
        final JSONParser parser = new JSONParserImpl();
        final HeadHunterApi api = HeadHunterApi.getInstance(parser);
        
        long areaId = 0;
        List<Region> r = RegionLocalServiceUtil.getRegionForName(area);
        if (!r.isEmpty()) {
            areaId = r.get(0).getId();
        } else {
            List<Locality> l = LocalityLocalServiceUtil.getLocalityForName(area);
            areaId = l.get(0).getId();
        }
        
        String searchText = "";
        if (!text.equals("")) {
            searchText = Arrays.stream(text.split(" "))
                               .collect(Collectors.joining("+"));
        }
        
        return api.getVacancies(page, perPage, areaId, searchText);
    }
    
    @Override
    public List<Region> getAreas() throws IOException, SystemException {
        final JSONParser parser = new JSONParserImpl();
        final HeadHunterApi api = HeadHunterApi.getInstance(parser);
        
        return api.getAreas();
    }

    @Override
    public int getPagesCount(int perPage) {
        final JSONParser parser = new JSONParserImpl();
        final HeadHunterApi api = HeadHunterApi.getInstance(parser);
        
        return api.getPagesCount();
    }
    
    @Override
    public String getErrorMsg() {
        final JSONParser parser = new JSONParserImpl();
        final HeadHunterApi api = HeadHunterApi.getInstance(parser);
        
        return api.getErrorMsg();
    }
}
