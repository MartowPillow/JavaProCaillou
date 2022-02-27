package com.example.demo.controller;

import com.example.demo.models.Product;
import org.hibernate.cfg.NotYetImplementedException;
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
        throw new NotYetImplementedException();
    }

    @GetMapping(value = "/basket/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> get(@RequestBody String email)
    {
        throw new NotYetImplementedException();
    }

    @PostMapping(value = "/basket/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@RequestBody String email)
    {
        throw new NotYetImplementedException();
    }

    @DeleteMapping(value = "/basket/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> delete(@RequestBody String email)
    {
        throw new NotYetImplementedException();
    }

}
