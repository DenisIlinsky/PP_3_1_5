package com.akira.restparser;

import com.akira.restparser.model.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class Client {

    static RestTemplate restTemplate = new RestTemplate();
    static String stringUrl = "http://94.198.50.185:7081/api/users";

    public static void useExchangeMethodsOfRestTemplate() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

        System.out.println(headers);

        ResponseEntity<List> responseEntity = getListUserByExchangeMethod(requestEntity);

        headers.set("Cookie", responseEntity.getHeaders().get("Set-Cookie").stream().collect(Collectors.joining(";")));

        System.out.println(headers);

        User sysUser = new User();
        sysUser.setId(3L);
        sysUser.setName("James");
        sysUser.setLastName("Brown");
        sysUser.setAge((byte) 25);
        HttpEntity<User> userRequestEntity = new HttpEntity<>(sysUser, headers);

        addUserByExchangeMethod(userRequestEntity);

        sysUser.setName("Thomas");
        sysUser.setLastName("Shelby");


        userRequestEntity = new HttpEntity<>(sysUser, headers);
        System.out.println(headers);

        updateUserByExchangeMethod(userRequestEntity);

        deleteUserByExchangeMethod(userRequestEntity);
    }

        private static void deleteUserByExchangeMethod(HttpEntity<User> requestEntity) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(stringUrl + "/3",
                HttpMethod.DELETE,
                requestEntity,
                String.class);
        HttpStatus statusCode = (HttpStatus) responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String userDetails = responseEntity.getBody();
        System.out.println("response body - " + userDetails);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response Headers - " + responseHeaders);
    }

    private static void updateUserByExchangeMethod(HttpEntity<User> requestEntity) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(stringUrl,
                HttpMethod.PUT,
                requestEntity,
                String.class);
        HttpStatus statusCode = (HttpStatus) responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String userDetails = responseEntity.getBody();
        System.out.println("response body - " + userDetails);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response Headers - " + responseHeaders);
    }

    private static void addUserByExchangeMethod(HttpEntity<User> requestEntity) {
        ResponseEntity<String> responseEntity = restTemplate.exchange(stringUrl,
                HttpMethod.POST,
                requestEntity,
                String.class);
        HttpStatus statusCode = (HttpStatus) responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        String userDetails = responseEntity.getBody();
        System.out.println("response body - " + userDetails);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response Headers - " + responseHeaders);
    }


    private static ResponseEntity<List> getListUserByExchangeMethod(HttpEntity<Object> requestEntity) {
        ResponseEntity<List> responseEntity = restTemplate.exchange(stringUrl,
                HttpMethod.GET,
                requestEntity,
                List.class);

        HttpStatus statusCode = (HttpStatus) responseEntity.getStatusCode();
        System.out.println("status code - " + statusCode);
        List user = responseEntity.getBody();
        System.out.println("response body - " + user);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("response Headers - " + responseHeaders);

        return responseEntity;
/*
        ResponseEntity<User> responseUser = restTemplate.exchange(baseUrl + "user/5",
                HttpMethod.GET,
                requestEntity,
                User.class);
        User userBody = responseUser.getBody();
        System.out.println("user object - " + userBody);*/
    }
}
