package com.optica.optica.controllers;

import com.optica.optica.models.Compra;
import com.optica.optica.repositories.CompraRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraRepository repository;

    public CompraController(CompraRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Compra> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Compra buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Compra crear(@RequestBody Compra compra) {
        return repository.save(compra);
    }

    @PutMapping("/{id}")
    public Compra actualizar(@PathVariable Long id, @RequestBody Compra compra) {
        compra.setId(id);
        return repository.save(compra);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
