package com.gl.userManagementClient;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */
public class ForEntityMethodOfRestTemplateDemo {
    private String baseUrl = "http://localhost:8083/springDataDemo/";

    RestTemplate restTemplate= new RestTemplate();

    public void driverMethod(){
        System.out.println("*********** forEntity() methods demo ***********");
        getSingleObject();
        getListObject();
        addUser();
        deleteUser();
        updateUser();
    }
    private void getSingleObject() {
        String url = baseUrl + "/user/5";
        ResponseEntity<String> user = restTemplate.getForEntity(url, String.class);
        HttpStatus statusCode = user.getStatusCode();
        System.out.println("status code - " + statusCode);
        String userDetails = user.getBody();
        System.out.println("response body - " + userDetails);
        HttpHeaders responseHeaders = user.getHeaders();
        System.out.println("response Headers - " + responseHeaders);
    }

    private void getListObject() {
        String url = baseUrl + "/users";
        ResponseEntity<List> user = restTemplate.getForEntity(url, List.class);
        HttpStatus statusCode = user.getStatusCode();
        System.out.println("status code - " + statusCode);
        List<Object> userDetails = user.getBody();
        System.out.println("response body - " + userDetails);
        HttpHeaders responseHeaders = user.getHeaders();
        System.out.println("response Headers - " + responseHeaders);
    }

    private void addUser() {
        String url = baseUrl + "/user";
        User user = new User();
        user.setFirstName("Green");
        user.setLastName("Learner");
        user.setGender("M");
        user.setAddress("Noida");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, user, String.class);

        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String userDetails = responseEntity.getBody();
        System.out.println("response body - " + userDetails);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response Headers - " + responseHeaders);
        URI uri = restTemplate.postForLocation(url, user, String.class);
        System.out.println("uri - " + uri);
    }

    private void deleteUser(){
        String url = baseUrl + "/user/20";
        restTemplate.delete(url);
        System.out.println("User deleted");
    }
    private void updateUser(){
        String url = baseUrl + "/updateAddress/5/USA";
        restTemplate.put(url, null);
        System.out.println("User updates");
    }
}
