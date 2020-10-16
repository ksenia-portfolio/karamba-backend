package com.karamba.games.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;


}
