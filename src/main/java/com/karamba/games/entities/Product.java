package com.karamba.games.entities;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Category category;

    private String name;

    private String description;

    private BigDecimal unitPrice;

    private String imageUrl;

    private int unitsInStock;

}
