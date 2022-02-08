package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.models.Product.ProductJson.Nutriment;
import com.example.demo.repositories.RuleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RuleService {

    private final RuleRepository repository;

    @Autowired
    public RuleService(RuleRepository repository) {
        this.repository = repository;
    }

    public int computeScore(Product entity) {
        log.trace("Calling computeScore with {}", entity.toString());

        Nutriment nutriment = entity.product.nutriments;
        int scoreN = 0, scoreP = 0;

        scoreN += repository.getComponentPoints("energy_100g", nutriment.energy);
        scoreN += repository.getComponentPoints("saturated-fat_100g", nutriment.saturatedFat);
        scoreN += repository.getComponentPoints("sugars_100g", nutriment.sugar);
        scoreN += repository.getComponentPoints("salt_100g", nutriment.salt);

        scoreP += repository.getComponentPoints("fiber_100g", nutriment.fiber);
        scoreP += repository.getComponentPoints("proteins_100g", nutriment.proteins);

        return scoreN - scoreP;
    }
}
