package com.example.hhapi;

import com.example.myservice.model.Vacancy;
import com.liferay.portal.kernel.exception.SystemException;

import java.io.IOException;
import java.util.List;

public interface HeadHunterApiService {
    List<Vacancy> getVacancies(int page, int perPage) throws IOException, SystemException;
    List<Vacancy> searchVacancies(String text) throws IOException, SystemException;
    int getPagesCount(int perPage) throws IOException;
    String getErrorMsg();
}
