package com.example.demo.repositories;

import com.example.demo.entities.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepository {
    @Autowired
    private Sql2o sql2o;

    public List<Ranking> findAll() {
        String sql = "SELECT * FROM ranking";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Ranking.class);
        }
    }

    public Ranking findById(Long id) {
        String sql = "SELECT * FROM ranking WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Ranking.class);
        }
    }

    public void save(Ranking ranking) {
        String sql = "INSERT INTO ranking (voluntario_id, puntuacion) VALUES (:voluntarioId, :puntuacion)";
        try (Connection con = sql2o.open()) {
            Long id = (Long) con.createQuery(sql, true)
                    .bind(ranking)
                    .executeUpdate()
                    .getKey();
            ranking.setId(id);
        }
    }

    public void update(Ranking ranking) {
        String sql = "UPDATE ranking SET voluntario_id = :voluntarioId, puntuacion = :puntuacion WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .bind(ranking)
                    .executeUpdate();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM ranking WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
