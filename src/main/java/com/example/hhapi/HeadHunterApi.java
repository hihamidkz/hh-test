package com.example.hhapi;

import com.example.hhapi.util.JSONParser;
import com.example.myservice.model.Region;
import com.example.myservice.model.Vacancy;
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

/**
 * Class for gathering data from HH.RU using REST API
 */
public final class HeadHunterApi {
    private final String BASE_URL = "https://api.hh.ru/";
    private final String USER_AGENT = "HHTest/0.1";
    private final String AREA = "1202";
    private final String SPECIALIZATION = "1";
    
    private JSONParser parser;
    
    private String errorMsg = "";
    private int pagesCount = -1;
    
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
    
    /**
     * Get all vacancies
     */
    public List<Vacancy> getVacancies(int page, int perPage)
            throws IOException, SystemException {
        Map<String, String> params = new HashMap<>();
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
            pagesCount = -1;
            return null;
        }
        
        InputStream in = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
        String response = br.lines().collect(Collectors.joining());
        
        pagesCount = parser.parsePagesCount(response);
        return parser.parseVacancies(response);
    }
    
    /**
     * Search vacancies with the given text
     */
    public List<Vacancy> getVacancies(int page, int perPage, String text)
            throws IOException, SystemException {
        Map<String, String> params = new HashMap<>();
        params.put("area", AREA);
        params.put("specialization", SPECIALIZATION);
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        params.put("text", text);
        
        String requestUrl = getRequestUrl("vacancies", params);
        
        URL url = new URL(requestUrl.toString());
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.addRequestProperty("User-Agent", USER_AGENT);
        
        int responseCode = conn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            errorMsg = conn.getResponseMessage();
            pagesCount = -1;
            return null;
        }
        
        InputStream in = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
        String response = br.lines().collect(Collectors.joining());
        
        pagesCount = parser.parsePagesCount(response);
        return parser.parseVacancies(response);
    }
    
    /**
     * Search vacancies for the specified area
     */
    public List<Vacancy> getVacancies(int page, int perPage, long area, String text)
            throws IOException, SystemException {
        Map<String, String> params = new HashMap<>();
        params.put("area", String.valueOf(area));
        params.put("specialization", SPECIALIZATION);
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        params.put("text", text);
        
        String requestUrl = getRequestUrl("vacancies", params);
        
        URL url = new URL(requestUrl.toString());
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.addRequestProperty("User-Agent", USER_AGENT);
        
        int responseCode = conn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            errorMsg = conn.getResponseMessage();
            pagesCount = -1;
            return null;
        }
        
        InputStream in = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
        String response = br.lines().collect(Collectors.joining());
        
        pagesCount = parser.parsePagesCount(response);
        return parser.parseVacancies(response);
    }
    
    /**
     * Get all areas
     */
    public List<Region> getAreas() throws IOException, SystemException {
        String requestUrl = getRequestUrl("areas", null);
        
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
        
        return parser.parseRegions(response);
    }
    
    private String getRequestUrl(String rest, Map<String, String> params) {
        StringBuilder requestUrl = new StringBuilder(BASE_URL);
        requestUrl.append(rest);
        
        if (params == null) {
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
    
    public int getPagesCount() {
        return pagesCount;
    }
}
