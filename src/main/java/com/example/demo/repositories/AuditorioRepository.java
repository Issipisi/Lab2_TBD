package com.example.demo.repositories;


import com.example.demo.entities.Auditorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Map;

@Repository
public class AuditorioRepository {
    @Autowired
    private Sql2o sql2o;


    public List<Map<String, Object>> obtenerReporteUsuariosQueries() {
        String sql = "SELECT * FROM reporte_usuarios_queries()";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetchTable().asList();
        }
    }


    public List<Auditorio> findAll() {
        String sql = "SELECT * FROM auditorio";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Auditorio.class);
        }
    }
}
