package com.example.demo.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmergenciaHabilidad {
    private Long id;
    private Long emergenciaId; // FK a Emergencia
    private Long habilidadId;  // FK a Habilidad
    // ... otros atributos y getters/setters
}
