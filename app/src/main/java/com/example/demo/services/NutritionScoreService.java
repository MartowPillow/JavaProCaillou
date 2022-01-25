package com.example.demo.services;

import com.example.demo.repositories.NutritionScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NutritionScoreService {

    private final NutritionScoreRepository repository;

    @Autowired
    public NutritionScoreService(NutritionScoreRepository repository) {
        this.repository = repository;
    }

}
