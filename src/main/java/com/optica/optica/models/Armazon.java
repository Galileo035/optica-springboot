package com.optica.optica.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.util.List;

@Entity
@Data
public class Armazon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String material;
    private double precio;

    @OneToMany(mappedBy = "armazon")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Compra> compras;
}
