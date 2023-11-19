package com.example.demo.repositories;

import com.example.demo.entities.Institucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class InstitucionRepository {
    @Autowired
    private Sql2o sql2o;

    public List<Institucion> findAll() {
        final String sql = "SELECT id, nombre, ubicacion FROM institucion";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Institucion.class);
        }
    }

    public Institucion findById(Long id) {
        final String sql = "SELECT id, nombre, ubicacion FROM institucion WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Institucion.class);
        }
    }

    public void save(Institucion institucion) {
        final String sql = "INSERT INTO institucion (nombre, ubicacion) VALUES (:nombre, :ubicacion)";
        try (Connection con = sql2o.open()) {
            Long id = (Long) con.createQuery(sql, true)
                    .bind(institucion)
                    .executeUpdate()
                    .getKey();
            institucion.setId(id);
        }
    }

    public void update(Institucion institucion) {
        final String sql = "UPDATE institucion SET nombre = :nombre, ubicacion = :ubicacion WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .bind(institucion)
                    .executeUpdate();
        }
    }

    public void delete(Long id) {
        final String sql = "DELETE FROM institucion WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
