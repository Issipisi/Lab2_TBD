package com.example.demo.servicesTest;

import com.example.demo.entities.Voluntario;
import com.example.demo.repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Voluntario voluntario = voluntarioRepository.findByCorreoUsingSql2o(correo);

        if (voluntario == null || StringUtils.isEmpty(voluntario.getCorreo()) || StringUtils.isEmpty(voluntario.getContrasena())){
            throw new UsernameNotFoundException("Usuario no encontrado o datos inválidos");
        }

        // Si tu aplicación tiene roles, deberías agregarlos aquí.
        List<GrantedAuthority> authorities = new ArrayList<>();
        // Ejemplo: authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(voluntario.getCorreo(), voluntario.getContrasena(), authorities);
    }
}

