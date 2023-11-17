package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Auditorio {
    private Long id;
    private Integer user_id;
    private String operation_type;
    private String query_text;
    private Timestamp execution_time;
    private String lastQuery;
}

