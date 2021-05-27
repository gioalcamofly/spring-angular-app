package com.example.springangularapp.controllers;

import com.example.springangularapp.models.Comment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController extends BaseController {

    private final String endpointUrl = "/comments";

    @GetMapping(endpointUrl)
    public Comment[] getComments() {
        return restTemplate.getForObject(
                baseUrl + endpointUrl,
                Comment[].class
        );
    }

    @GetMapping(endpointUrl + "/{id}")
    public Comment getCommentById(@PathVariable Comment id) {
        return restTemplate.getForObject(
                baseUrl + endpointUrl + "/" + id,
                Comment.class
        );
    }

    @PostMapping(endpointUrl)
    public Comment createComment(@RequestBody Comment comment) {
        return restTemplate.postForObject(
                baseUrl + endpointUrl,
                comment,
                Comment.class
        );
    }

    @PutMapping(endpointUrl + "/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        HttpEntity<Comment> requestUpdate = new HttpEntity<>(comment);
        return restTemplate.exchange(
                baseUrl + endpointUrl + "/" + id,
                HttpMethod.PUT,
                requestUpdate,
                Comment.class
        );
    }
}
