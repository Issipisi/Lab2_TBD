package com.example.demo.servicesTest;

import com.example.demo.entities.VolHabilidad;
import com.example.demo.repositories.VolHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolHabilidadService {
    @Autowired
    private VolHabilidadRepository volHabilidadRepository;

    public List<VolHabilidad> findAll() {
        return volHabilidadRepository.findAll();
    }

    public VolHabilidad findById(Long id) {
        return volHabilidadRepository.findById(id);
    }

    public void save(VolHabilidad volHabilidad) {
        volHabilidadRepository.save(volHabilidad);
    }

    public void update(VolHabilidad volHabilidad) {
        volHabilidadRepository.update(volHabilidad);
    }

    public void delete(Long id) {
        volHabilidadRepository.delete(id);
    }
}
