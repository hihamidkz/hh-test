package com.example.hhapi;

import com.example.myservice.model.Vacancy;
import com.liferay.portal.kernel.exception.SystemException;

import java.io.IOException;
import java.util.List;

public interface HeadHunterApiService {
    public List<Vacancy> getAllVacancies() throws IOException, SystemException;
    public List<Vacancy> searchVacancies(String text) throws IOException, SystemException;
}
