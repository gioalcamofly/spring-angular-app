package com.example.springangularapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public abstract class BaseController {

    @Value("${url}")
    protected String baseUrl;

    @Autowired
    RestTemplate restTemplate;

}
