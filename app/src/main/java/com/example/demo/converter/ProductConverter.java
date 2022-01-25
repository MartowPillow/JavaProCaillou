package com.example.demo.converter;

import com.example.demo.models.Product;
import com.example.demo.models.ProductDTO;
import com.example.demo.services.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private final RuleService service;

    @Autowired
    public ProductConverter(RuleService service) {
        this.service = service;
    }

    public ProductDTO toDTO(Product entity) {
        return ProductDTO.builder()
                .id(0)
                .barCode(entity.code)
                .name(String.format("%s - %s", entity.product.genericName, entity.product.name))
                .nutritionScore(service.computeScore(entity))
                .build();
    }
}
