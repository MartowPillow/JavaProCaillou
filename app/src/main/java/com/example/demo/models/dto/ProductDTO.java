package com.example.demo.models.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDTO {

    private int id;

    private String barCode;

    private String name;

    private int nutritionScore;

    private String classe;

    public String color;

}
