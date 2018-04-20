/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busy.minds.com;

import busy.minds.com.dist.DistansModel;
import busy.minds.com.geo.GeoCodeModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author local_user
 */
public class RestCallHandler {
    //Get the weather of the specific city
    DistansModel getDistanceJson(String cityName) throws RuntimeException, MalformedURLException, IOException{  
        
        String units = "metric";
        String origins = "place_id:ChIJWXPCW5B0_UYRdz3FIbROiSg";
        String apiKey = "AIzaSyBqoshQte1ox1DMAD-9knaGWOHnmFjdw_k";
        
        String googleDistanceUrl = String.format("https://maps.googleapis.com/maps/api/distancematrix/json?units=%s&origins=%s&destinations=%s&key=%s",
            units,
            origins,
            cityName,
            apiKey
        );

        DistansModel model = (DistansModel)new Caller(DistansModel.class).getJson(googleDistanceUrl, null);

        return model;
    }
    
    GeoCodeModel getCoords(String cityName) throws IOException {
        String url = "http://maps.google.com/maps/api/geocode/json?address=" + cityName;
        
        GeoCodeModel model = (GeoCodeModel)new Caller(GeoCodeModel.class).getJson(url, null);

        return model;
    }

//    JsonElement getWeather(String cityName) throws IOException {
//        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + ",pl";
//        return getJson(url, "2508abecb6d9037229e719a6adc445af");
//    }
    
    private class Caller<T>{
        
        Class<T> t;
        public Caller(Class<T> t) {
            this.t = t;
        }
        
        public T getJson(String requestUrl, String apiKey) throws UnsupportedEncodingException, IOException {
            URL url = new URL(requestUrl);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            conn = (HttpURLConnection)url.openConnection();  
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("apikey", apiKey);

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                              + conn.getResponseCode());
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"))){
                String output = null;

                StringBuilder strBuf = new StringBuilder();
                while ((output = reader.readLine()) != null)  
                    strBuf.append(output);
                
                String dumped = strBuf.toString();
                
                return new Gson().fromJson(dumped, t);
            }
        }
        
    }
    
    
    
}
