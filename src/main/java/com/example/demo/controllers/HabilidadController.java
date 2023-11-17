package com.example.demo.controllers;

import com.example.demo.entities.Habilidad;
import com.example.demo.servicesTest.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidades")
public class HabilidadController {
    @Autowired
    private HabilidadService habilidadService;

    @GetMapping
    public List<Habilidad> findAll() {
        return habilidadService.findAll();
    }

    @GetMapping("/{id}")
    public Habilidad findById(@PathVariable Long id) {
        return habilidadService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Habilidad habilidad) {
        habilidadService.save(habilidad);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Habilidad habilidad) {
        if (id.equals(habilidad.getId())) {
            habilidadService.update(habilidad);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        habilidadService.delete(id);
    }
}
