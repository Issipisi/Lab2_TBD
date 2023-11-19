package com.example.demo.entities;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.postgresql.geometric.PGpoint;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voluntario {
    private Long id;
    private String nombre;
    private String apellido;
    private PGpoint ubicacion;
    private String correo;
    private String contrasena;
    private Long idtarea;
}
