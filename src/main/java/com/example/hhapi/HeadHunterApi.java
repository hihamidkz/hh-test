package com.example.hhapi;

import com.example.myservice.model.Vacancy;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

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

public final class HeadHunterApi {
    private final String BASE_URL = "https://api.hh.ru/";
    private final String USER_AGENT = "HHTest/0.1";
    private final String AREA = "1202";
    private final String SPECIALIZATION = "1";
    private final String PAGE = "0";
    
    private JSONParser parser;
    
    private String errorMsg = "";
    
    private static HeadHunterApi instance = null;
    
    private HeadHunterApi(JSONParser parser) {
        this.parser = parser;
    }
    
    public static HeadHunterApi getInstance(JSONParser parser) {
        if (instance == null) {
            instance = new HeadHunterApi(parser);
        }
        
        return instance;
    }
    
    public List<Vacancy> getVacancies(int page, int perPage) throws IOException, SystemException {
        Map<String, String> params = new HashMap<>();
        params.put("area", AREA);
        params.put("specialization", SPECIALIZATION);
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        
        String requestUrl = getRequestUrl("vacancies", params);
        
        URL url = new URL(requestUrl.toString());
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.addRequestProperty("User-Agent", USER_AGENT);
        
        int responseCode = conn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            errorMsg = conn.getResponseMessage();
            return null;
        }
        
        InputStream in = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
        String response = br.lines().collect(Collectors.joining());
        
        return parser.parseVacancies(response);
    }
    
    public int getPagesCount(int perPage) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("area", AREA);
        params.put("specialization", SPECIALIZATION);
        params.put("page", PAGE);
        params.put("per_page", String.valueOf(perPage));
        
        String requestUrl = getRequestUrl("vacancies", params);
        
        URL url = new URL(requestUrl.toString());
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.addRequestProperty("User-Agent", USER_AGENT);
        
        int responseCode = conn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            errorMsg = conn.getResponseMessage();
            return -1;
        }
        
        InputStream in = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
        String response = br.lines().collect(Collectors.joining());
        
        return parser.parsePagesCount(response);
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
    
    public String getErrorMsg() {
        return errorMsg;
    }
}
