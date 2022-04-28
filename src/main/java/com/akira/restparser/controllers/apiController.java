package com.akira.restparser.controllers;

import com.akira.restparser.model.User;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.List;

@Controller
public class apiController {

    RestTemplate restTemplate = new RestTemplate();
    String stringUrl = "http://94.198.50.185:7081/api/users";

    @GetMapping("/")
    public String main() {

        return "index";
    }

}
