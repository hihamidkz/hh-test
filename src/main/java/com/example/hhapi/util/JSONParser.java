package com.example.hhapi.util;

import com.example.myservice.model.Region;
import com.example.myservice.model.Vacancy;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

public interface JSONParser {
    List<Vacancy> parseVacancies(String json) throws SystemException;
    int parsePagesCount(String json);
    List<Region> parseRegions(String json) throws SystemException;
}
