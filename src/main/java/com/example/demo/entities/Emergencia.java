package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Emergencia {
    private Long id;
    private String nombre;
    private String descripcion;
    private String ubicacion;// Formato "POINT(longitud latitud)"
    private Long institucionId; // FK a Institucion
    // ... otros atributos y getters/setters
}
