package com.example.demo.controller;

import com.example.demo.models.Product;
import com.example.demo.models.ProductParser;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/product")
    public Product getProduct()
    {
        return service.generate();
    }

    @GetMapping(value = "/product/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductParser getProduct(@PathVariable String barcode)
    {
        return service.getByBarcode(barcode);
    }
}
