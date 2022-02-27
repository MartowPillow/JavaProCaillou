package com.example.demo.services;

import com.example.demo.models.exceptions.ApiException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
public class ProductServiceTest {

    private ProductService service;

    @BeforeEach
    void init() {
        service = new ProductService();
    }

    @Test
    void sanity() {
        assertThrows(ApiException.class, () -> service.getByBarcode(""));
        assertThrows(ApiException.class, () -> service.getByBarcode(null));
        assertThrows(ApiException.class, () -> service.getByBarcode("    "));
        assertThrows(ApiException.class, () -> service.getByBarcode("notaproduct"));
    }

}
