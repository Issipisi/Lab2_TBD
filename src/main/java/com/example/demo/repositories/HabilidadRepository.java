package com.example.demo.repositories;

import com.example.demo.entities.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class HabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    public List<Habilidad> findAll() {
        String sql = "SELECT * FROM habilidad";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Habilidad.class);
        }
    }

    public Habilidad findById(Long id) {
        String sql = "SELECT * FROM habilidad WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Habilidad.class);
        }
    }

    public void save(Habilidad habilidad) {
        String sql = "INSERT INTO habilidad (descripcion) VALUES (:descripcion)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql, true)
                    .bind(habilidad)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void update(Habilidad habilidad) {
        String sql = "UPDATE habilidad SET descripcion = :descripcion WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .bind(habilidad)
                    .executeUpdate();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM habilidad WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
