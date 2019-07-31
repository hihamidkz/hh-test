package com.example.hhapi;

import com.example.myservice.model.Vacancy;
import com.liferay.portal.kernel.exception.SystemException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeadHunterApiServiceImpl implements HeadHunterApiService {

    @Override
    public List<Vacancy> getVacancies(int page, int perPage) throws IOException, SystemException {
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
        
        return api.searchVacancies(page, perPage, searchText);
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
