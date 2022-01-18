package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductParser implements Serializable {

    @JsonProperty("code")
    public String code;

    @JsonProperty("product")
    public ProductJson product;

    public class ProductJson {

        @JsonProperty("nutriments")
        public Nutriment nutriments;

        public class Nutriment {

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
