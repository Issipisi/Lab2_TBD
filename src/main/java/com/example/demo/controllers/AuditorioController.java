package com.example.demo.controllers;

import com.example.demo.entities.Auditorio;

import com.example.demo.servicesTest.AuditorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auditorio")
@CrossOrigin(origins = "*")
public class AuditorioController {
    @Autowired
    private AuditorioService auditorioService;

    @GetMapping("/reporte-usuarios-queries")
    public List<Map<String, Object>> obtenerReporteUsuariosQueries() {
        return auditorioService.obtenerReporteUsuariosQueries();
    }

    @GetMapping("/auditorios")
    public List<Auditorio> findAll() { return auditorioService.findAll(); }


}
