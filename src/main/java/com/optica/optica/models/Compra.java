package com.optica.optica.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fecha;
    private double total;

    @ManyToOne
    @JsonIgnoreProperties("compras")
    private Cliente cliente;

    @ManyToOne
    @JsonIgnoreProperties("compras")
    private Armazon armazon;

    @ManyToOne
    @JsonIgnoreProperties("compras")
    private Graduacion graduacion;
}
