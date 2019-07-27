package com.example.hhapi;

import com.example.myservice.model.Vacancy;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

public interface JSONParser {
    List<Vacancy> parseVacancies(String json) throws SystemException;
    int parsePagesCount(String json);
}
