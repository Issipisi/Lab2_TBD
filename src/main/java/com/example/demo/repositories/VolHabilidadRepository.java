package com.example.demo.repositories;

import com.example.demo.entities.VolHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VolHabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    public List<VolHabilidad> findAll() {
        String sql = "SELECT * FROM vol_habilidad";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(VolHabilidad.class);
        }
    }

    public VolHabilidad findById(Long id) {
        String sql = "SELECT * FROM vol_habilidad WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(VolHabilidad.class);
        }
    }

    public void save(VolHabilidad volHabilidad) {
        String sql = "INSERT INTO vol_habilidad (voluntario_id, habilidad_id) VALUES (:voluntarioId, :habilidadId)";
        try (Connection con = sql2o.open()) {
            Long id = (Long) con.createQuery(sql, true)
                    .bind(volHabilidad)
                    .executeUpdate()
                    .getKey();
            volHabilidad.setId(id);
        }
    }

    public void update(VolHabilidad volHabilidad) {
        String sql = "UPDATE vol_habilidad SET voluntario_id = :voluntarioId, habilidad_id = :habilidadId WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .bind(volHabilidad)
                    .executeUpdate();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM vol_habilidad WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
