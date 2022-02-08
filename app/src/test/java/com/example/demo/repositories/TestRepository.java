package com.example.demo.repositories;

import com.example.demo.models.NutritionScore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TestRepository {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private NutritionScoreRepository repository;

    @Test
    public void findAll() {
        entityManager.persist(new NutritionScore());


    }
}
