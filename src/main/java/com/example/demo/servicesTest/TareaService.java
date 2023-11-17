package com.example.demo.servicesTest;

import com.example.demo.entities.Tarea;
import com.example.demo.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    public Tarea findById(Long id) {
        return tareaRepository.findById(id);
    }

    public void save(Tarea tarea) {
        tareaRepository.save(tarea);
    }

    public void update(Tarea tarea) {
        tareaRepository.update(tarea);
    }

    public void delete(Long id) {
        tareaRepository.delete(id);
    }

    public List<Tarea> findByEmergenciaId(Long emergenciaId){
        return tareaRepository.findByEmergenciaId(emergenciaId);
    }
}
