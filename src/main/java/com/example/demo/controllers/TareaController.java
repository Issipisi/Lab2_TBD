package com.example.demo.controllers;

import com.example.demo.entities.Tarea;
import com.example.demo.servicesTest.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
@CrossOrigin(origins = "*")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @GetMapping
    public List<Tarea> findAll() {
        return tareaService.findAll();
    }

    @GetMapping("/{id}")
    public Tarea findById(@PathVariable Long id) {
        return tareaService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Tarea tarea) {
        tareaService.save(tarea);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Tarea tarea) {
        if (id.equals(tarea.getId())) {
            tareaService.update(tarea);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tareaService.delete(id);
    }
}
