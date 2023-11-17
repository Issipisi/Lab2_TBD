package com.example.demo.controllers;

import com.example.demo.entities.EmergenciaHabilidad;
import com.example.demo.servicesTest.EmergenciaHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergenciasHabilidades")
public class EmergenciaHabilidadController {
    @Autowired
    private EmergenciaHabilidadService emergenciaHabilidadService;

    @GetMapping
    public List<EmergenciaHabilidad> findAll() {
        return emergenciaHabilidadService.findAll();
    }

    @GetMapping("/{id}")
    public EmergenciaHabilidad findById(@PathVariable Long id) {
        return emergenciaHabilidadService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody EmergenciaHabilidad emergenciaHabilidad) {
        emergenciaHabilidadService.save(emergenciaHabilidad);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody EmergenciaHabilidad emergenciaHabilidad) {
        if (id.equals(emergenciaHabilidad.getId())) {
            emergenciaHabilidadService.update(emergenciaHabilidad);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        emergenciaHabilidadService.delete(id);
    }
}
