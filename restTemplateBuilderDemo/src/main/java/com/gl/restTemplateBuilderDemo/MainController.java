package com.gl.restTemplateBuilderDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */

@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/userList")
    List<User> getUserList(){
        return restTemplate.getForObject("/users",
                List.class);
    }
}
