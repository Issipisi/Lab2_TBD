package com.example.demo.controllers;

import com.example.demo.entities.EstadoTarea;
import com.example.demo.servicesTest.EstadoTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadosTarea")
public class EstadoTareaController {
    @Autowired
    private EstadoTareaService estadoTareaService;

    @GetMapping
    public List<EstadoTarea> findAll() {
        return estadoTareaService.findAll();
    }

    @GetMapping("/{id}")
    public EstadoTarea findById(@PathVariable Long id) {
        return estadoTareaService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody EstadoTarea estadoTarea) {
        estadoTareaService.save(estadoTarea);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody EstadoTarea estadoTarea) {
        if (id.equals(estadoTarea.getId())) {
            estadoTareaService.update(estadoTarea);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        estadoTareaService.delete(id);
    }
}
