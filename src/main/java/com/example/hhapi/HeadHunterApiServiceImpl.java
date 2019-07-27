package com.example.hhapi;

import com.example.myservice.model.Vacancy;
import com.liferay.portal.kernel.exception.SystemException;

import java.io.IOException;
import java.util.List;

public class HeadHunterApiServiceImpl implements HeadHunterApiService {

    @Override
    public List<Vacancy> getVacancies(int page, int perPage) throws IOException, SystemException {
        final JSONParser parser = new JSONParserImpl();
        final HeadHunterApi api = new HeadHunterApi(parser);
        
        return api.getVacancies(page, perPage);
    }

    @Override
    public List<Vacancy> searchVacancies(String text) throws IOException, SystemException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getPagesCount(int perPage) throws IOException {
        final JSONParser parser = new JSONParserImpl();
        final HeadHunterApi api = new HeadHunterApi(parser);
        
        return api.getPagesCount(perPage);
    }
}
