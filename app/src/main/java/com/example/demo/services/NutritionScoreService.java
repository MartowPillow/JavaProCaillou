package com.example.demo.services;

import com.example.demo.repositories.NutritionScoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NutritionScoreService {

    private final NutritionScoreRepository repository;

    @Autowired
    public NutritionScoreService(NutritionScoreRepository repository){
        this.repository = repository;
    }

    public String getClasse(int nutriscore) {
        log.trace("Calling getClasse with {}", nutriscore);
        return repository.getClasse(nutriscore);
    }

    public String getColor(int nutriscore) {
        log.trace("Calling getColor with {}", nutriscore);
        return repository.getColor(nutriscore);
    }

}
