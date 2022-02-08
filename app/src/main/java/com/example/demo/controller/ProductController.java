package com.example.demo.controller;

import com.example.demo.mapper.ProductConverter;
import com.example.demo.models.Product;
import com.example.demo.models.dto.ProductDTO;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private final ProductConverter converter;

    @Autowired
    public ProductController(ProductService service, ProductConverter productConverter) {
        this.service = service;
        this.converter = productConverter;
    }

    @GetMapping(value = "/product/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> getProduct(@PathVariable String barcode) {
        Product product = service.getByBarcode(barcode);
        ProductDTO productDTO = converter.toDTO(product);

        return ResponseEntity.status(HttpStatus.OK)
                .body(productDTO);
    }

    @GetMapping(value = "/product/raw/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getRawProduct(@PathVariable String barcode)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getByBarcode(barcode));
    }
}
