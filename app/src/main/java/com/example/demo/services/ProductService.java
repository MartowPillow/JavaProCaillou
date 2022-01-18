package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.models.ProductParser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final String API_URL = "https://fr.openfoodfacts.org/api/v0/produit";

    public ProductService() {
        // Add dependencies
    }

    public Product generate() {
        return Product.builder()
                .id(0)
                .barCode("test")
                .name("test")
                .nutritionScore(0)
                .build();
    }

    public List<Product> getAll() {
        return null;
    }

    public ProductParser getByBarcode(String barcode) {
        RestTemplate restTemplate = new RestTemplate();
        ProductParser response = restTemplate.getForObject("%s/%s.json".formatted(API_URL, barcode), ProductParser.class);
        return response;
    }
}
