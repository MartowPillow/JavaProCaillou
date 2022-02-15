package com.example.demo.controller;

import com.example.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class BasketController {

    @Autowired
    public BasketController() {

    }

    @PostMapping(value = "/basket/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> create(@RequestBody String email)
    {
        return null;
    }

    @GetMapping(value = "/basket/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> get(@RequestBody String email)
    {
        return null;
    }

    @PostMapping(value = "/basket/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@RequestBody String email)
    {
        return null;
    }

    @DeleteMapping(value = "/basket/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> delete(@RequestBody String email)
    {
        return null;
    }

}
