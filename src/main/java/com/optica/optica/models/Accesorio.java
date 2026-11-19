package com.optica.optica.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Accesorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double precio;
}
