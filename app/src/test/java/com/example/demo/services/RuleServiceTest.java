package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.models.Product.ProductJson;
import com.example.demo.models.Product.ProductJson.Nutriment;
import com.example.demo.models.exceptions.ApiException;
import com.example.demo.repositories.RuleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RuleServiceTest {

    @Mock
    private RuleRepository repository;

    @InjectMocks
    private RuleService service;

    @Test
    void contextLoads() {
        assertEquals(0, repository.count(), "You should try to set spring.profiles.active to test in env variables");
    }

    @Test
    void sanity() {
        assertThrows(ApiException.class, () -> service.computeScore(null));
    }

    @Test
    void computeProduct() {
        Product product = new Product("7622210449283", new ProductJson(
                "Prince Chocolat",
                "BISCUITS FOURRÉS (35%) PARFUM CHOCOLAT",
                new Nutriment(
                        1962.0,
                        5.6,
                        32.0,
                        0.49,
                        4.0,
                        6.3
                )
        ));

        when(repository.getComponentPoints(eq("energy_100g"), anyDouble())).thenReturn(5d);
        when(repository.getComponentPoints(eq("saturated-fat_100g"), anyDouble())).thenReturn(5d);
        when(repository.getComponentPoints(eq("sugars_100g"), anyDouble())).thenReturn(7d);
        when(repository.getComponentPoints(eq("salt_100g"), anyDouble())).thenReturn(0d);
        when(repository.getComponentPoints(eq("fiber_100g"), anyDouble())).thenReturn(5d);
        when(repository.getComponentPoints(eq("proteins_100g"), anyDouble())).thenReturn(3d);

        assertEquals(9, service.computeScore(product));
    }

}
