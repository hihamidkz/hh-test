package com.example.hhapi.service;

import com.example.myservice.model.Region;
import com.example.myservice.model.Vacancy;
import com.liferay.portal.kernel.exception.SystemException;

import java.io.IOException;
import java.util.List;

public interface HeadHunterApiService {
    List<Vacancy> getVacancies(int page, int perPage)
            throws IOException, SystemException;
    List<Vacancy> searchVacancies(int page, int perPage, String text)
            throws IOException, SystemException;
    List<Vacancy> searchVacanciesForArea(int page,
                                         int perPage,
                                         String area,
                                         String text)
                 throws IOException, SystemException;
    List<Region> getAreas() throws IOException, SystemException;
    int getPagesCount(int perPage);
    String getErrorMsg();
}
