package com.example.hhapi;

import com.example.model.Vacancy;

import java.util.List;

public interface JSONParser {
    List<Vacancy> parseVacancies(String json);
}
