package com.example.demo.controller;

import com.example.demo.converter.ProductConverter;
import com.example.demo.models.Product;
import com.example.demo.models.ProductDTO;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class ProductController {

    private final ProductService service;
    private final ProductConverter converter;

    @Autowired
    public ProductController(ProductService service, ProductConverter productConverter) {
        this.service = service;
        this.converter = productConverter;
    }

    @GetMapping(value = "/product/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO getProduct(@PathVariable String barcode)
    {
        Product product = service.getByBarcode(barcode);
        return converter.toDTO(product);
    }

    @GetMapping(value = "/product/raw/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getRawProduct(@PathVariable String barcode)
    {
        return service.getByBarcode(barcode);
    }
}
