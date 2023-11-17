package com.example.demo.repositories;

import com.example.demo.entities.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaRepository {
    @Autowired
    private Sql2o sql2o;

    public List<Tarea> findAll() {
        String sql = "SELECT * FROM tarea";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Tarea.class);
        }
    }

    public Tarea findById(Long id) {
        String sql = "SELECT * FROM tarea WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Tarea.class);
        }
    }

    public List<Tarea> findByEmergenciaId(Long emergenciaId) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM tarea WHERE emergenciaId = :emergenciaId")
                    .addParameter("emergenciaId", emergenciaId)
                    .executeAndFetch(Tarea.class);
        }
    }


    public void save(Tarea tarea) {
        String sql = "INSERT INTO tarea (nombre, descripcion, emergenciaId, estadoTareaId) VALUES (:nombre, :descripcion, :emergenciaId, :estadoTareaId)";
        try (Connection con = sql2o.open()) {
            Long id = (Long) con.createQuery(sql, true)
                    .bind(tarea)
                    .executeUpdate()
                    .getKey();
            tarea.setId(id);
        }
    }

    public void update(Tarea tarea) {
        String sql = "UPDATE tarea SET nombre = :nombre, descripcion = :descripcion, emergenciaId = :emergenciaId, estadoTareaId = :estadoTareaId WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .bind(tarea)
                    .executeUpdate();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM tarea WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}