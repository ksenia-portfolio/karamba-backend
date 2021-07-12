package com.karamba.games.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String purchaseCode;

    @Enumerated
    private Status status;

    @CreatedDate
    private LocalDate date;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Customer customer;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Product> products;


}
