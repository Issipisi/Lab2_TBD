package com.example.demo.repositories;

import com.example.demo.entities.EstadoTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EstadoTareaRepository {
    @Autowired
    private Sql2o sql2o;

    public List<EstadoTarea> findAll() {
        String sql = "SELECT * FROM estado_tarea";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(EstadoTarea.class);
        }
    }

    public EstadoTarea findById(Long id) {
        String sql = "SELECT * FROM estado_tarea WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EstadoTarea.class);
        }
    }

    public void save(EstadoTarea estadoTarea) {
        String sql = "INSERT INTO estado_tarea (estado) VALUES (:estado)";
        try (Connection con = sql2o.open()) {
            Long id = (Long) con.createQuery(sql, true)
                    .bind(estadoTarea)
                    .executeUpdate()
                    .getKey();
            estadoTarea.setId(id);
        }
    }

    public void update(EstadoTarea estadoTarea) {
        String sql = "UPDATE estado_tarea SET estado = :estado WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .bind(estadoTarea)
                    .executeUpdate();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM estado_tarea WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
