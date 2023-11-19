package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.postgresql.geometric.PGpoint;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Institucion {
    private Long id;
    private String nombre;
    private PGpoint ubicacion;
    // ... otros atributos y getters/setters
}
