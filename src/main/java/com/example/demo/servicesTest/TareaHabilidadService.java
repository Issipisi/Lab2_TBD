package com.example.demo.servicesTest;

import com.example.demo.entities.TareaHabilidad;
import com.example.demo.repositories.TareaHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaHabilidadService {
    @Autowired
    private TareaHabilidadRepository tareaHabilidadRepository;

    public List<TareaHabilidad> findAll() {
        return tareaHabilidadRepository.findAll();
    }

    public TareaHabilidad findById(Long id) {
        return tareaHabilidadRepository.findById(id);
    }

    public void save(TareaHabilidad tareaHabilidad) {
        tareaHabilidadRepository.save(tareaHabilidad);
    }

    public void update(TareaHabilidad tareaHabilidad) {
        tareaHabilidadRepository.update(tareaHabilidad);
    }

    public void delete(Long id) {
        tareaHabilidadRepository.delete(id);
    }
}
