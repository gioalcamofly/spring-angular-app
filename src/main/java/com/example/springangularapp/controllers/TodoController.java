package com.example.springangularapp.controllers;

import com.example.springangularapp.models.Todo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController extends BaseController {

    private final String endpointUrl = "/todos";

    @GetMapping(endpointUrl)
    public Todo[] getTodos() {
        return restTemplate.getForObject(
                baseUrl + endpointUrl,
                Todo[].class
        );
    }

    @GetMapping(endpointUrl + "/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return restTemplate.getForObject(
                baseUrl + endpointUrl + "/" + id,
                Todo.class
        );
    }

    @PostMapping(endpointUrl)
    public Todo createTodo(@RequestBody Todo todo) {
        return restTemplate.postForObject(
                baseUrl + endpointUrl,
                todo,
                Todo.class
        );
    }

    @PutMapping(endpointUrl + "/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        HttpEntity<Todo> requestUpdate = new HttpEntity<>(todo);
        return restTemplate.exchange(
                baseUrl + endpointUrl + "/" + id,
                HttpMethod.PUT,
                requestUpdate,
                Todo.class
        );
    }
}
