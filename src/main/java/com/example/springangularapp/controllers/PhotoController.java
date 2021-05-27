package com.example.springangularapp.controllers;

import com.example.springangularapp.models.Photo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhotoController extends BaseController {

    private final String endpointUrl = "/photos";

    @GetMapping(endpointUrl)
    public Photo[] getPhotos() {
        return restTemplate.getForObject(
                baseUrl + endpointUrl,
                Photo[].class
        );
    }

    @GetMapping(endpointUrl + "/{id}")
    public Photo getPhotoById(@PathVariable Long id) {
        return restTemplate.getForObject(
                baseUrl + endpointUrl + "/" + id,
                Photo.class
        );
    }

    @PostMapping(endpointUrl)
    public Photo createPhoto(@RequestBody Photo photo) {
        return restTemplate.postForObject(
                baseUrl + endpointUrl,
                photo,
                Photo.class
        );
    }

    @PutMapping(endpointUrl + "/{id}")
    public ResponseEntity<Photo> updatePhoto(@PathVariable Long id, @RequestBody Photo photo) {
        HttpEntity<Photo> requestUpdate = new HttpEntity<>(photo);
        return restTemplate.exchange(
                baseUrl + endpointUrl + "/" + id,
                HttpMethod.PUT,
                requestUpdate,
                Photo.class
        );
    }
}
