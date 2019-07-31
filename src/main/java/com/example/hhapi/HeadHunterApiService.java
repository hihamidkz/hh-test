package com.example.hhapi;

import com.example.myservice.model.Vacancy;
import com.liferay.portal.kernel.exception.SystemException;

import java.io.IOException;
import java.util.List;

public interface HeadHunterApiService {
    List<Vacancy> getVacancies(int page, int perPage)
            throws IOException, SystemException;
    List<Vacancy> searchVacancies(int page, int perPage, String text)
            throws IOException, SystemException;
    int getPagesCount(int perPage);
    String getErrorMsg();
}
