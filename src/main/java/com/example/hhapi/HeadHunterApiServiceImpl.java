package com.example.hhapi;

import com.example.myservice.model.Vacancy;
import com.liferay.portal.kernel.exception.SystemException;

import java.io.IOException;
import java.util.List;

public class HeadHunterApiServiceImpl implements HeadHunterApiService {

    @Override
    public List<Vacancy> getAllVacancies() throws IOException, SystemException {
        final JSONParser parser = new JSONParserImpl();
        final HeadHunterApi api = new HeadHunterApi(parser);
        
        return api.getVacancies();
    }

    @Override
    public List<Vacancy> searchVacancies(String text) throws IOException, SystemException {
        // TODO Auto-generated method stub
        return null;
    }

}
