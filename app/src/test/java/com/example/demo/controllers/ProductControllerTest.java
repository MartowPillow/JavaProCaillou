package com.example.demo.controllers;

import com.example.demo.controller.ProductController;
import com.example.demo.mapper.ProductConverter;
import com.example.demo.models.Product;
import com.example.demo.models.dto.ProductDTO;
import com.example.demo.models.exceptions.ApiException;
import com.example.demo.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.AdditionalMatchers.not;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductConverter productConverter;

    @BeforeEach
    public void setup() {
        final Product product = new Product("7622210449283", new Product.ProductJson(
                "Prince Chocolat",
                "BISCUITS FOURRÉS (35%) PARFUM CHOCOLAT",
                new Product.ProductJson.Nutriment(
                        1962.0,
                        5.6,
                        32.0,
                        0.49,
                        4.0,
                        6.3
                )
        ));
        final ProductDTO dto = ProductDTO.builder()
                .id(0)
                .barCode(product.code)
                .name(String.format("%s - %s", product.product.genericName, product.product.name))
                .nutritionScore(9)
                .classe("Mauvais")
                .color("Red")
                .build();

        when(productService.getByBarcode(eq(product.code))).thenReturn(product);
        when(productService.getByBarcode(not(eq(product.code)))).thenThrow(new ApiException("Unable to find product"));
        when(productConverter.toDTO(any())).thenReturn(dto);
    }

    @Test
    public void getRawProduct() throws Exception {
        mvc.perform(get("/api/product/raw/7622210449283")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    @Test
    public void getProduct() throws Exception {
        mvc.perform(get("/api/product/7622210449283")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    @Test
    public void getProductFail() throws Exception {
        mvc.perform(get("/api/product/eee")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().is4xxClientError());
    }
}
