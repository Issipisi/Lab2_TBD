package com.example.demo.repositories;

import com.example.demo.entities.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntarioRepository {
    @Autowired
    private Sql2o sql2o;

    public List<Voluntario> findAll() {
        final String sql = "SELECT id, nombre, apellido, geom as ubicacion, correo, contrasena, idtarea FROM voluntario";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Voluntario.class);
        }
    }

    public Voluntario findById(Long id) {
        final String sql = "SELECT id, nombre, apellido, geom as ubicacion, correo, contrasena, idtarea FROM voluntario WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Voluntario.class);
        }
    }

    public void save(Voluntario voluntario) {
        final String sql = "INSERT INTO voluntario (nombre, apellido, geom, correo, contrasena, idtarea) VALUES (:nombre, :apellido, :ubicacion, :correo, :contrasena, :idtarea)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql, true)
                    .bind(voluntario)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void update(Voluntario voluntario) {
        final String sql = "UPDATE voluntario SET nombre = :nombre, apellido = :apellido, geom = :ubicacion, correo = :correo, contrasena = :contrasena, idtarea = :idtarea WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .bind(voluntario)
                    .executeUpdate();
        }
    }

    public void delete(Long id) {
        final String sql = "DELETE FROM voluntario WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    // Método para buscar un Voluntario por correo utilizando SQL2o
    public Voluntario findByCorreoUsingSql2o(String correo) {
        String sql = "SELECT * FROM voluntario WHERE correo = :correo";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("correo", correo)
                    .executeAndFetchFirst(Voluntario.class);
        }
    }
}
