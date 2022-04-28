package com.akira.restparser;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class RestparserApplication {
    public static void main(String[] args) {
        Client.useExchangeMethodsOfRestTemplate();
        SpringApplication.run(RestparserApplication.class, args);
    }
}
