package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@Table(name="nutrition_score")
public class NutritionScore {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    public Long id;

    @Column(name = "classe", length = 50, nullable = false)
    public String classe;

    @Column(name = "lower_bound", nullable = false)
    public int lowerBound;

    @Column(name = "upper_bound", nullable = false)
    public int upperBound;

    @Column(name = "color", length = 50, nullable = false)
    public String color;

}