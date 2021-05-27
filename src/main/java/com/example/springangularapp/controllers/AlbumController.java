package com.example.springangularapp.controllers;

import com.example.springangularapp.models.Album;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlbumController extends BaseController {

    private final String endpointUrl = "/albums";

    @GetMapping(endpointUrl)
    public Album[] getAlbums() {
        return restTemplate.getForObject(
                baseUrl + endpointUrl,
                Album[].class
        );
    }

    @GetMapping(endpointUrl + "/{id}")
    public Album getAlbumById(@PathVariable Long id) {
        return restTemplate.getForObject(
                baseUrl + endpointUrl + "/" + id,
                Album.class
        );
    }

    @PostMapping(endpointUrl)
    public Album createAlbum(@RequestBody Album album) {
        return restTemplate.postForObject(
                baseUrl + endpointUrl,
                album,
                Album.class
        );
    }

    @PutMapping(endpointUrl + "/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable Long id, @RequestBody Album album) {
        HttpEntity<Album> requestUpdate = new HttpEntity<>(album);
        return restTemplate.exchange(
                baseUrl + endpointUrl + "/" + id,
                HttpMethod.PUT,
                requestUpdate,
                Album.class
        );
    }
}
