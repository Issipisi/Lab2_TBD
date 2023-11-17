package com.example.demo.controllers;

import com.example.demo.entities.Institucion;
import com.example.demo.servicesTest.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/instituciones")
public class InstitucionController {
    @Autowired
    private InstitucionService institucionService;

    @GetMapping
    public List<Institucion> findAll() {
        return institucionService.findAll();
    }

    @GetMapping("/{id}")
    public Institucion findById(@PathVariable Long id) {
        return institucionService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Institucion institucion) {
        institucionService.save(institucion);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Institucion institucion) {
        if (id.equals(institucion.getId())) {
            institucionService.update(institucion);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        institucionService.delete(id);
    }
}

