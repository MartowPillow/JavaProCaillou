package com.example.demo.mapper;

import com.example.demo.models.Product;
import com.example.demo.models.dto.ProductDTO;
import com.example.demo.services.NutritionScoreService;
import com.example.demo.services.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private final RuleService ruleService;
    private final NutritionScoreService nutriscoreService;

    @Autowired
    public ProductConverter(RuleService service, NutritionScoreService nutriscoreService) {
        this.ruleService = service;
        this.nutriscoreService = nutriscoreService;
    }

    public ProductDTO toDTO(Product entity) {
        final int nutriscore = ruleService.computeScore(entity);

        return ProductDTO.builder()
                .id(0)
                .barCode(entity.code)
                .name(String.format("%s - %s", entity.product.genericName, entity.product.name))
                .nutritionScore(ruleService.computeScore(entity))
                .classe(nutriscoreService.getClasse(nutriscore))
                .color(nutriscoreService.getColor(nutriscore))
                .build();
    }
}
