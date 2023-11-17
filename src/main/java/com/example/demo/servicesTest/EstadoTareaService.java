package com.example.demo.servicesTest;

import com.example.demo.entities.EstadoTarea;
import com.example.demo.repositories.EstadoTareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoTareaService {
    @Autowired
    private EstadoTareaRepository estadoTareaRepository;

    public List<EstadoTarea> findAll() {
        return estadoTareaRepository.findAll();
    }

    public EstadoTarea findById(Long id) {
        return estadoTareaRepository.findById(id);
    }

    public void save(EstadoTarea estadoTarea) {
        estadoTareaRepository.save(estadoTarea);
    }

    public void update(EstadoTarea estadoTarea) {
        estadoTareaRepository.update(estadoTarea);
    }

    public void delete(Long id) {
        estadoTareaRepository.delete(id);
    }
}
