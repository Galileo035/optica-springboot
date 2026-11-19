package com.optica.optica.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Armazon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String material;
    private double precio;
}
