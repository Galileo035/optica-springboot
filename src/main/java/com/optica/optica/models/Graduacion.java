package com.optica.optica.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;

@Entity
@Data
public class Graduacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private double precio;

    @OneToMany(mappedBy = "graduacion")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Compra> compras;
}
