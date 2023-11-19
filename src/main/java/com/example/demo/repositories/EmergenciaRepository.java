package com.example.demo.repositories;

import com.example.demo.entities.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaRepository {
    @Autowired
    private Sql2o sql2o;

    public List<Emergencia> findAll() {
        final String sql = "SELECT id, nombre, descripcion, ST_AsText(ubicacion) as ubicacion, institucion_id FROM emergencia";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Emergencia.class);
        }
    }

    public Emergencia findById(Long emergenciaId) {
        final String sql = "SELECT id, nombre, descripcion, ST_AsText(ubicacion) as ubicacion, institucion_id FROM emergencia WHERE id = :emergenciaId";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("emergenciaId", emergenciaId)
                    .executeAndFetchFirst(Emergencia.class);
        }
    }

    public void save(Emergencia emergencia) {
        final String sql = "INSERT INTO emergencia (nombre, descripcion, ubicacion, institucion_id) VALUES (:nombre, :descripcion, ST_GeomFromText(:ubicacion, 4326), :institucion_id)";
        try (Connection con = sql2o.open()) {
            Long id = (Long) con.createQuery(sql, true)
                    .bind(emergencia)
                    .executeUpdate()
                    .getKey();
            emergencia.setId(id);
        }
    }

    public void update(Emergencia emergencia) {
        final String sql = "UPDATE emergencia SET nombre = :nombre, descripcion = :descripcion, ubicacion = ST_GeomFromText(:ubicacion, 4326), institucion_id = :institucion_id WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .bind(emergencia)
                    .executeUpdate();
        }
    }

    public void delete(Long id) {
        final String sql = "DELETE FROM emergencia WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}

