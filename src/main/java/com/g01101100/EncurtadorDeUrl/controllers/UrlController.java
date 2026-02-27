package com.g01101100.EncurtadorDeUrl.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.net.URI;

import com.g01101100.EncurtadorDeUrl.services.UrlService;
import com.g01101100.EncurtadorDeUrl.dtos.CreateUrlRequest;
import com.g01101100.EncurtadorDeUrl.dtos.CreateUrlResponse;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {

        String originalUrl = service.getOriginalUrl(code);

        return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .location(URI.create(originalUrl))
                .build();
    }

    @PostMapping("/urls")
    public ResponseEntity<CreateUrlResponse> createURL(
            @RequestBody CreateUrlRequest request) {

        String shortCode = service.createShortUrl(request.getOriginalUrl());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new CreateUrlResponse(shortCode));
    }
}
