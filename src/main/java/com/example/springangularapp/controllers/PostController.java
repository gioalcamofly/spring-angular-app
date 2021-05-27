package com.example.springangularapp.controllers;

import com.example.springangularapp.models.Post;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController extends BaseController {

    private final String endpointUrl = "/posts";

    @GetMapping(endpointUrl)
    public Post[] getPosts() {
        return restTemplate.getForObject(
                baseUrl + endpointUrl,
                Post[].class
        );
    }

    @GetMapping(endpointUrl + "/{id}")
    public Post getPostById(@PathVariable Long id) {
        return restTemplate.getForObject(
                baseUrl + endpointUrl + "/" + id,
                Post.class
        );
    }

    @PostMapping(endpointUrl)
    public Post createPost(@RequestBody Post post) {
        return restTemplate.postForObject(
                baseUrl + endpointUrl,
                post,
                Post.class
        );
    }

    @PutMapping(endpointUrl + "/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        HttpEntity<Post> requestUpdate = new HttpEntity<>(post);
        return restTemplate.exchange(
                baseUrl + endpointUrl + "/" + id,
                HttpMethod.PUT,
                requestUpdate,
                Post.class
        );
    }
}
