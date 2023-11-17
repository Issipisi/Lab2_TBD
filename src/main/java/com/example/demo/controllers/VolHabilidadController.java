package com.example.demo.controllers;

import com.example.demo.entities.VolHabilidad;
import com.example.demo.servicesTest.VolHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volHabilidades")
public class VolHabilidadController {
    @Autowired
    private VolHabilidadService volHabilidadService;

    @GetMapping
    public List<VolHabilidad> findAll() {
        return volHabilidadService.findAll();
    }

    @GetMapping("/{id}")
    public VolHabilidad findById(@PathVariable Long id) {
        return volHabilidadService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody VolHabilidad volHabilidad) {
        volHabilidadService.save(volHabilidad);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody VolHabilidad volHabilidad) {
        if (id.equals(volHabilidad.getId())) {
            volHabilidadService.update(volHabilidad);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        volHabilidadService.delete(id);
    }
}
