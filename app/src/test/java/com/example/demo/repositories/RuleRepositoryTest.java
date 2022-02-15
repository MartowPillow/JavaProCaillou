package com.example.demo.repositories;

import com.example.demo.models.NutritionScore;
import com.example.demo.models.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RuleRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RuleRepository repository;

    @Test
    void contextLoads() {
        assertEquals(0, repository.count(), "You should try to set spring.profiles.active to test in env variables");
    }

    @Test
    public void computePoints() {
        List<Rule> list = Arrays.asList(
                new Rule(1L, "energy_100g", 0, 0, "N"),
                new Rule(2L, "energy_100g", 2, 400, "N"),
                new Rule(3L, "energy_100g", 4, 1340, "N")
        );

        list.forEach(entityManager::persist);
        assertEquals(list.size(), repository.count());

        assertEquals(0, repository.getComponentPoints("energy_100g", 0));

        assertEquals(0, repository.getComponentPoints("energy_100g", 200));
        assertEquals(2, repository.getComponentPoints("energy_100g", 1000));
        assertEquals(4, repository.getComponentPoints("energy_100g", 2000));

    }
}