package com.example.hhapi;

import com.example.model.Vacancy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HeadHunterApi {
    final String BASE_URL = "https://api.hh.ru/";
    final String USER_AGENT = "HHTest/0.1";
    final String AREA = "1202";
    final String SPECIALIZATION = "1";
    final String PAGE = "1";
    final String PER_PAGE = "2";
    
    JSONParser parser;
    
    public HeadHunterApi(JSONParser parser) {
        this.parser = parser;
    }
    
    public List<Vacancy> getVacancies() throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("area", AREA);
        params.put("specialization", SPECIALIZATION);
        params.put("page", PAGE);
        params.put("per_page", PER_PAGE);
        
        String requestUrl = getRequestUrl("vacancies", params);
        
        URL url = new URL(requestUrl.toString());
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.addRequestProperty("User-Agent", USER_AGENT);
        
        InputStream in = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
        String response = br.lines().collect(Collectors.joining());
        
        return parser.parseVacancies(response);
    }
    
    private String getRequestUrl(String rest, Map<String, String> params) {
        StringBuilder requestUrl = new StringBuilder(BASE_URL);
        requestUrl.append(rest);
        
        if (params.isEmpty()) {
            return requestUrl.toString();
        }
        
        requestUrl.append("?");
        for (String param : params.keySet()) {
            requestUrl.append(param);
            requestUrl.append("=" + params.get(param) + "&");
        }
        
        return requestUrl.toString();
    }
}
