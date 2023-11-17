package com.example.demo.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {
    private Long id;
    private String nombre;
    private String descripcion;
    private Long emergenciaId; // FK a Emergencia
    private Long estadoTareaId; // FK a EstadoTarea
    // ... otros atributos y getters/setters
}
