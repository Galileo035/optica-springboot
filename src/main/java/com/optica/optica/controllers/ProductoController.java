package com.optica.optica.controllers;

import com.optica.optica.models.Producto;
import com.optica.optica.repositories.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoRepository repository;

    public ProductoController(ProductoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Producto> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return repository.save(producto);
    }
}