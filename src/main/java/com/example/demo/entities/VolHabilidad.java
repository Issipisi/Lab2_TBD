package com.example.demo.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolHabilidad {
    private Long id;
    private Long voluntarioId; // FK a Voluntario
    private Long habilidadId;  // FK a Habilidad
    // ... otros atributos y getters/setters
}
