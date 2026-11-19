package com.optica.optica.controllers;

import com.optica.optica.models.Accesorio;
import com.optica.optica.repositories.AccesorioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accesorios")
public class AccesorioController {

    private final AccesorioRepository repository;

    public AccesorioController(AccesorioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Accesorio> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Accesorio buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Accesorio crear(@RequestBody Accesorio accesorio) {
        return repository.save(accesorio);
    }

    @PutMapping("/{id}")
    public Accesorio actualizar(@PathVariable Long id, @RequestBody Accesorio accesorio) {
        accesorio.setId(id);
        return repository.save(accesorio);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
