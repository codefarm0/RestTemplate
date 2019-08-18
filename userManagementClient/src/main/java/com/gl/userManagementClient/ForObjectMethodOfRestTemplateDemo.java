package com.gl.userManagementClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */
public class ForObjectMethodOfRestTemplateDemo {
    private Logger logger = LoggerFactory.getLogger(ForObjectMethodOfRestTemplateDemo.class);
    private String baseUrl = "http://localhost:8083/springDataDemo/";

    private RestTemplate restTemplate = new RestTemplate();

    public void driverMethod(){
        System.out.println("*********** forObject() method demo ***********");
        getSingleObject();
        getListObject();
        addUser();
    }
    private void getSingleObject() {
        String url = baseUrl + "/user/5";
        String user = restTemplate.getForObject(url, String.class);
        logger.info("User - " + user);
    }

    private void getListObject() {
        String url = baseUrl + "/users";
        List userDetails = restTemplate.getForObject(url, List.class);
        logger.info("response body - " + userDetails);

    }

    private void addUser() {
        String url = baseUrl + "/user";
        User user = new User();
        user.setFirstName("Green");
        user.setLastName("Learner");
        user.setGender("M");
        user.setAddress("Noida");
        String response = restTemplate.postForObject(url, user, String.class);

        logger.info("response - " + response);

    }
}
