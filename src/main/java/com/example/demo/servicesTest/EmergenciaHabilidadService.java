package com.example.demo.servicesTest;

import com.example.demo.entities.EmergenciaHabilidad;
import com.example.demo.repositories.EmergenciaHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergenciaHabilidadService {
    @Autowired
    private EmergenciaHabilidadRepository emergenciaHabilidadRepository;

    public List<EmergenciaHabilidad> findAll() {
        return emergenciaHabilidadRepository.findAll();
    }

    public EmergenciaHabilidad findById(Long id) {
        return emergenciaHabilidadRepository.findById(id);
    }

    public void save(EmergenciaHabilidad emergenciaHabilidad) {
        emergenciaHabilidadRepository.save(emergenciaHabilidad);
    }

    public void update(EmergenciaHabilidad emergenciaHabilidad) {
        emergenciaHabilidadRepository.update(emergenciaHabilidad);
    }

    public void delete(Long id) {
        emergenciaHabilidadRepository.delete(id);
    }
}
