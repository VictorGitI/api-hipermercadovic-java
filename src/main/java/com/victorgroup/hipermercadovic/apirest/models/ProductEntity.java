package com.victorgroup.hipermercadovic.apirest.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String description;
    private String category;
    private double price;
    private int stock;
    private String model;
    private BigDecimal weight;
    private Date manufacturingDate;

    public ProductEntity(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

}
