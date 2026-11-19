package com.optica.optica.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Graduacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private double precio;
}
