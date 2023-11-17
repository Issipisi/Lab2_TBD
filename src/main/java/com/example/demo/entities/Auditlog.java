package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auditlog {
    private Long id;
    private Integer userId;
    private String operationType;
    private String queryText;
    private Timestamp executionTime;
}
