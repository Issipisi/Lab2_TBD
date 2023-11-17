package com.example.demo.servicesTest;

import com.example.demo.entities.Habilidad;
import com.example.demo.repositories.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadService {
    @Autowired
    private HabilidadRepository habilidadRepository;

    public List<Habilidad> findAll() {
        return habilidadRepository.findAll();
    }

    public Habilidad findById(Long id) {
        return habilidadRepository.findById(id);
    }

    public void save(Habilidad habilidad) {
        habilidadRepository.save(habilidad);
    }

    public void update(Habilidad habilidad) {
        habilidadRepository.update(habilidad);
    }

    public void delete(Long id) {
        habilidadRepository.delete(id);
    }
}
