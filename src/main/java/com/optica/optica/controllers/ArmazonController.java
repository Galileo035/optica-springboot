package com.optica.optica.controllers;

import com.optica.optica.models.Armazon;
import com.optica.optica.repositories.ArmazonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armazones")
public class ArmazonController {

    private final ArmazonRepository repository;

    public ArmazonController(ArmazonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Armazon> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Armazon buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Armazon crear(@RequestBody Armazon armazon) {
        return repository.save(armazon);
    }

    @PutMapping("/{id}")
    public Armazon actualizar(@PathVariable Long id, @RequestBody Armazon armazon) {
        armazon.setId(id);
        return repository.save(armazon);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
