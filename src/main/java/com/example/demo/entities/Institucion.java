package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Institucion {
    private Long id;
    private String nombre;
    private String ubicacion;
    // ... otros atributos y getters/setters
}
