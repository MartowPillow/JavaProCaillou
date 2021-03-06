package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {

    @JsonProperty("code")
    public String code;

    @JsonProperty("product")
    public ProductJson product;

    @AllArgsConstructor
    public static class ProductJson {

        @JsonProperty("product_name")
        public String name;

        @JsonProperty("generic_name")
        public String genericName;

        @JsonProperty("nutriments")
        public Nutriment nutriments;

        @AllArgsConstructor
        public static class Nutriment {

            @JsonProperty("energy_100g")
            public Double energy;

            @JsonProperty("saturated-fat_100g")
            public Double saturatedFat;

            @JsonProperty("sugars_100g")
            public Double sugar;

            @JsonProperty("salt_100g")
            public Double salt;

            @JsonProperty("fiber_100g")
            public Double fiber;

            @JsonProperty("proteins_100g")
            public Double proteins;

        }
    }
}
