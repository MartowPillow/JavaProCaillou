package com.example.demo.repositories;

import com.example.demo.models.NutritionScore;
import com.example.demo.models.Rule;
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
public class NutritionScoreRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private NutritionScoreRepository repository;

    @Test
    void contextLoads() {
        assertEquals(0, repository.count(), "You should try to set spring.profiles.active to test in env variables");
    }

    @Test
    void computeClasses() {
        final String BEST_CLASS = "green";
        final String BEST_LABEL = "Trop Bon";
        final String WORST_CLASS = "red";
        final String WORST_LABEL = "Degueu";

        List<NutritionScore> list = Arrays.asList(
                new NutritionScore(1L, BEST_LABEL, -10, -1, BEST_CLASS),
                new NutritionScore(2L, "Bon", 0, 2, "light green"),
                new NutritionScore(3L, "Mangeable", 3, 10, "yellow"),
                new NutritionScore(4L, "Mouai", 11, 18, "orange"),
                new NutritionScore(5L, WORST_LABEL, 19, 40, WORST_CLASS)
        );

        list.forEach(entityManager::persist);
        assertEquals(list.size(), repository.count());

        assertEquals(BEST_CLASS, repository.getColor(-2));
        assertEquals(WORST_LABEL, repository.getClasse(25));

        assertNull(repository.getColor(-15));
        assertNull(repository.getClasse(50));
    }
}
