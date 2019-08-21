package com.gl.restTemplateBuilderDemo.config;

import org.springframework.web.client.RestTemplate;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */
public class GoogleTest {
    public static void main(String[] args) {
        RestTemplate rt = new RestTemplate();

        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=";
        String address = "india";
        String key = "&key=custom-key";//"AIzaSyAX_1d4cEaA50VZDg6BIJ_TSnncbLWiegY";
        url=url+address+key;
        System.out.println(url);
        String response = rt.getForObject(url, String.class);
        System.out.println(response);
    }
}
