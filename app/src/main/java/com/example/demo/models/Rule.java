package com.example.demo.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="rule")
public class Rule {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    public Long id;

    @Column(name = "name", length = 50, nullable = false)
    public String name;

    @Column(name = "points", nullable = false)
    public int points;

    @Column(name = "min_bound", nullable = false)
    public double minBound;

    @Column(name = "component", length = 1, nullable = false)
    public String component;

}
