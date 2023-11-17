package com.example.demo.servicesTest;


import com.example.demo.entities.Auditorio;
import com.example.demo.repositories.AuditorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuditorioService {
    @Autowired
    private AuditorioRepository auditorioRepository;

    public List<Map<String, Object>> obtenerReporteUsuariosQueries() {
        return auditorioRepository.obtenerReporteUsuariosQueries();
    }

    public List<Auditorio> findAll() {
        return auditorioRepository.findAll();
    }


}
