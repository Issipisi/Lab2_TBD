package com.example.demo.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ranking {
    private Long id;
    private Long voluntarioId; // FK a Voluntario
    private int puntuacion;
    // ... otros atributos y getters/setters
}
