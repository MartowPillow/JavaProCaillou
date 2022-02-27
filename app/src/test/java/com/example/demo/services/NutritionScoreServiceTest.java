package com.example.demo.services;

import com.example.demo.repositories.NutritionScoreRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class NutritionScoreServiceTest {

    @Mock
    private NutritionScoreRepository repository;

    @InjectMocks
    private NutritionScoreService service;

    @Test
    void test() {
        when(repository.getClasse(anyInt())).thenReturn("Mangeable");
        when(repository.getColor(anyInt())).thenReturn("red");

        assertEquals("Mangeable", service.getClasse(5));
        assertEquals("red", service.getColor(25));
    }

}
