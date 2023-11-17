package com.example.demo.servicesTest;

import com.example.demo.entities.Voluntario;
import com.example.demo.repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoluntarioService {
    @Autowired
    private VoluntarioRepository voluntarioRepository;

    public List<Voluntario> findAll() {
        return voluntarioRepository.findAll();
    }

    public Voluntario findById(Long id) {
        return voluntarioRepository.findById(id);
    }

    public void save(Voluntario voluntario) {
        voluntarioRepository.save(voluntario);
    }

    public void update(Voluntario voluntario) {
        voluntarioRepository.update(voluntario);
    }

    public void delete(Long id) {
        voluntarioRepository.delete(id);
    }

    public Voluntario findByCorreo(String correo) {
        return voluntarioRepository.findByCorreoUsingSql2o(correo);
    }



}
