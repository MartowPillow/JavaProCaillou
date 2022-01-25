package com.example.demo.services;

import com.example.demo.converter.ProductConverter;
import com.example.demo.models.Product;
import com.example.demo.models.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
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

    public List<ProductDTO> getAll() {
        return null;
    }

    public Product getByBarcode(String barcode) {
        RestTemplate restTemplate = new RestTemplate();
        Product response = restTemplate.getForObject("%s/%s.json".formatted(API_URL, barcode), Product.class);
        return response;
    }
}
