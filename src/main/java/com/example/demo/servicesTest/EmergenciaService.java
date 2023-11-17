package com.example.demo.servicesTest;

import com.example.demo.entities.Emergencia;
import com.example.demo.repositories.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergenciaService {
    @Autowired
    private EmergenciaRepository emergenciaRepository;

    public List<Emergencia> findAll() {
        return emergenciaRepository.findAll();
    }

    public Emergencia findById(Long id) {
        return emergenciaRepository.findById(id);
    }

    public void save(Emergencia emergencia) {
        emergenciaRepository.save(emergencia);
    }

    public void update(Emergencia emergencia) {
        emergenciaRepository.update(emergencia);
    }

    public void delete(Long id) {
        emergenciaRepository.delete(id);
    }
}
