package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "user", nullable = false, unique = true)
    private String user;

    @ElementCollection
    @CollectionTable(name = "basket_products", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "products", nullable = false, unique = false)
    private List<String> products;

}
