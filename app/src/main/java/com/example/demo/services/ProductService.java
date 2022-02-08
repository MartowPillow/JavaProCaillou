package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.models.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ProductService {

    private final String API_URL = "https://fr.openfoodfacts.org/api/v0/produit";

    public ProductDTO generate() {
        return ProductDTO.builder()
                .id(0)
                .barCode("test")
                .name("test")
                .nutritionScore(0)
                .build();
    }

    public Product getByBarcode(String barcode) {
        log.trace("Calling getByBarcode with {}", barcode);
        RestTemplate restTemplate = new RestTemplate();
        Product response = restTemplate.getForObject("%s/%s.json".formatted(API_URL, barcode), Product.class);
        return response;
    }

}
