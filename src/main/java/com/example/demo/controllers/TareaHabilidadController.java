package com.example.demo.controllers;

import com.example.demo.entities.TareaHabilidad;
import com.example.demo.servicesTest.TareaHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareasHabilidades")
public class TareaHabilidadController {
    @Autowired
    private TareaHabilidadService tareaHabilidadService;

    @GetMapping
    public List<TareaHabilidad> findAll() {
        return tareaHabilidadService.findAll();
    }

    @GetMapping("/{id}")
    public TareaHabilidad findById(@PathVariable Long id) {
        return tareaHabilidadService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody TareaHabilidad tareaHabilidad) {
        tareaHabilidadService.save(tareaHabilidad);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody TareaHabilidad tareaHabilidad) {
        if (id.equals(tareaHabilidad.getId())) {
            tareaHabilidadService.update(tareaHabilidad);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tareaHabilidadService.delete(id);
    }
}
