package com.example.demo.controllers;

import com.example.demo.entities.Emergencia;
import com.example.demo.servicesTest.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergencias")
@CrossOrigin(origins = "*")
public class EmergenciaController {
    @Autowired
    private EmergenciaService emergenciaService;


    @GetMapping
    public List<Emergencia> findAll() {
        return emergenciaService.findAll();
    }

    @GetMapping("/{id}")
    public Emergencia findById(@PathVariable Long id) {
        return emergenciaService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Emergencia emergencia) {
        emergenciaService.save(emergencia);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Emergencia emergencia) {
        if (id.equals(emergencia.getId())) {
            emergenciaService.update(emergencia);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        emergenciaService.delete(id);
    }
}
