package com.example.springangularapp.controllers;

import com.example.springangularapp.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;


@RestController
public class UserController extends BaseController {

    private final String endpointUrl = "/users";

    @GetMapping(endpointUrl)
    public User[] getUsers() {
        return restTemplate.getForObject(
            baseUrl + endpointUrl,
           User[].class
        );
    }

    @GetMapping(endpointUrl + "/json")
    public ResponseEntity<Object> saveToJsonFile() {
        User[] users = restTemplate.getForObject(
                baseUrl + endpointUrl,
                User[].class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = Paths.get("users.json").toFile();
            mapper.writeValue(file, users);
            return new ResponseEntity<>(file, HttpStatus.OK);
        } catch (IOException ex) {
            return new ResponseEntity<>("Could not write JSON file", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(endpointUrl + "/{id}")
    public User getUserById(@PathVariable Long id) {
        return restTemplate.getForObject(
        baseUrl + endpointUrl + "/" + id,
            User.class
        );
    }

    @PostMapping(endpointUrl)
    public User createUser(@RequestBody User user) {
        return restTemplate.postForObject(
            baseUrl + endpointUrl,
                user,
                User.class
        );
    }

    @PutMapping(endpointUrl + "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        HttpEntity<User> requestUpdate = new HttpEntity<>(user);
        return restTemplate.exchange(
                baseUrl + endpointUrl + "/" + id,
                HttpMethod.PUT,
                requestUpdate,
                User.class
        );
    }
}
