package com.example.demo.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaHabilidad {
    private Long id;
    private Long tareaId; // FK a Tarea
    private Long habilidadId;  // FK a Habilidad
    // ... otros atributos y getters/setters
}
