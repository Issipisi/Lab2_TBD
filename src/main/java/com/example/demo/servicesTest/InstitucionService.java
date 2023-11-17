package com.example.demo.servicesTest;

import com.example.demo.entities.Institucion;
import com.example.demo.repositories.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitucionService {
    @Autowired
    private InstitucionRepository institucionRepository;

    public List<Institucion> findAll() {
        return institucionRepository.findAll();
    }

    public Institucion findById(Long id) {
        return institucionRepository.findById(id);
    }

    public void save(Institucion institucion) {
        institucionRepository.save(institucion);
    }

    public void update(Institucion institucion) {
        institucionRepository.update(institucion);
    }

    public void delete(Long id) {
        institucionRepository.delete(id);
    }
}

