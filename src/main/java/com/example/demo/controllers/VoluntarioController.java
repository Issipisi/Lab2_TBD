package com.example.demo.controllers;

import com.example.demo.entities.Voluntario;
import com.example.demo.servicesTest.VoluntarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/voluntarios")
public class VoluntarioController {
    @Autowired
    private VoluntarioService voluntarioService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PutMapping("/{correo}")
    public void update(@PathVariable String correo, @RequestBody Voluntario voluntario) {
        if (correo.equals(voluntario.getCorreo())) {
            voluntarioService.update(voluntario);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Voluntario> register(@RequestBody Voluntario voluntario) {
        voluntarioService.save(voluntario);
        return ResponseEntity.ok(voluntario);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Voluntario voluntario) {
        try {// Realiza la autenticación utilizando Spring Security
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            voluntario.getCorreo(),
                            voluntario.getContrasena()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Si la autenticación es exitosa, devuelve una respuesta exitosa
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } catch (BadCredentialsException e) {
            // Si las credenciales son inválidas
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas.");
        } catch (AuthenticationException e) {
            // Para cualquier otra excepción relacionada con la autenticación
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Inicio de sesión fallido.");
        }
    }



    @GetMapping
    public List<Voluntario> findAll() {
        return voluntarioService.findAll();
    }

    @GetMapping("/{id:\\d+}")
    public Voluntario findById(@PathVariable Long id) {
        return voluntarioService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Voluntario voluntario) {
        voluntarioService.save(voluntario);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Voluntario voluntario) {
        if (id.equals(voluntario.getId())) {
            voluntarioService.update(voluntario);
        }
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        voluntarioService.delete(id);
    }


}