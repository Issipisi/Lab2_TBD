package com.example.demo.repositories;

import com.example.demo.entities.TareaHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaHabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    public List<TareaHabilidad> findAll() {
        String sql = "SELECT * FROM tarea_habilidad";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(TareaHabilidad.class);
        }
    }

    public TareaHabilidad findById(Long id) {
        String sql = "SELECT * FROM tarea_habilidad WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(TareaHabilidad.class);
        }
    }

    public void save(TareaHabilidad tareaHabilidad) {
        String sql = "INSERT INTO tarea_habilidad (tarea_id, habilidad_id) VALUES (:tareaId, :habilidadId)";
        try (Connection con = sql2o.open()) {
            Long id = (Long) con.createQuery(sql, true)
                    .bind(tareaHabilidad)
                    .executeUpdate()
                    .getKey();
            tareaHabilidad.setId(id);
        }
    }

    public void update(TareaHabilidad tareaHabilidad) {
        String sql = "UPDATE tarea_habilidad SET tarea_id = :tareaId, habilidad_id = :habilidadId WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .bind(tareaHabilidad)
                    .executeUpdate();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM tarea_habilidad WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
