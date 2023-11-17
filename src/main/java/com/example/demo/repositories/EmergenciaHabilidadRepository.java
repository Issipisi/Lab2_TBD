package com.example.demo.repositories;

import com.example.demo.entities.EmergenciaHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaHabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    public List<EmergenciaHabilidad> findAll() {
        String sql = "SELECT * FROM emergencia_habilidad";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(EmergenciaHabilidad.class);
        }
    }

    public EmergenciaHabilidad findById(Long id) {
        String sql = "SELECT * FROM emergencia_habilidad WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EmergenciaHabilidad.class);
        }
    }

    public void save(EmergenciaHabilidad emergenciaHabilidad) {
        String sql = "INSERT INTO emergencia_habilidad (emergencia_id, habilidad_id) VALUES (:emergenciaId, :habilidadId)";
        try (Connection con = sql2o.open()) {
            Long id = (Long) con.createQuery(sql, true)
                    .bind(emergenciaHabilidad)
                    .executeUpdate()
                    .getKey();
            emergenciaHabilidad.setId(id);
        }
    }

    public void update(EmergenciaHabilidad emergenciaHabilidad) {
        String sql = "UPDATE emergencia_habilidad SET emergencia_id = :emergenciaId, habilidad_id = :habilidadId WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .bind(emergenciaHabilidad)
                    .executeUpdate();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM emergencia_habilidad WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
