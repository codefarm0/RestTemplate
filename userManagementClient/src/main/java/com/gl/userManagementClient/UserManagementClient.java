package com.gl.userManagementClient;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/**
 * Author - Green Learner(https://facebook.com/greenlearner) <br>
 * Official youtube channel - https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA <br>
 */

//@SpringBootApplication
public class UserManagementClient {

    static RestTemplate restTemplate = new RestTemplate();
    static String baseUrl = "http://localhost:8083/springDataDemo/";


    public static void main(String[] args) {

        ///SpringApplication.run(UserManagementClient.class, args);

        useExchangeMethodsOfRestTemplate();
    }

    private static void useExchangeMethodsOfRestTemplate() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

        getSingleUserByExchangeMethod(requestEntity);

    }

    private static void getSingleUserByExchangeMethod(HttpEntity<Object> requestEntity) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "user/5",
                HttpMethod.GET,
                requestEntity,
                String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String user = responseEntity.getBody();
        System.out.println("response body - " + user);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response Headers - " + responseHeaders);

        ResponseEntity<User> responseUser = restTemplate.exchange(baseUrl + "user/5",
                HttpMethod.GET,
                requestEntity,
                User.class);
        User userBody = responseUser.getBody();
        System.out.println("user object - " + userBody);
    }
}
