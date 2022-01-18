package com.example.demo.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {
    private int id;
    private String barCode;
    private String name;
    private int nutritionScore;
}
