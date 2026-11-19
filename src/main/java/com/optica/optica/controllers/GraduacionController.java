package com.optica.optica.controllers;

import com.optica.optica.models.Graduacion;
import com.optica.optica.repositories.GraduacionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/graduaciones")
public class GraduacionController {

    private final GraduacionRepository repository;

    public GraduacionController(GraduacionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Graduacion> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Graduacion buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Graduacion crear(@RequestBody Graduacion graduacion) {
        return repository.save(graduacion);
    }

    @PutMapping("/{id}")
    public Graduacion actualizar(@PathVariable Long id, @RequestBody Graduacion graduacion) {
        graduacion.setId(id);
        return repository.save(graduacion);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
