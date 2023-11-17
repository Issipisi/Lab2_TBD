package com.example.demo.servicesTest;

import com.example.demo.entities.Ranking;
import com.example.demo.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {
    @Autowired
    private RankingRepository rankingRepository;

    public List<Ranking> findAll() {
        return rankingRepository.findAll();
    }

    public Ranking findById(Long id) {
        return rankingRepository.findById(id);
    }

    public void save(Ranking ranking) {
        rankingRepository.save(ranking);
    }

    public void update(Ranking ranking) {
        rankingRepository.update(ranking);
    }

    public void delete(Long id) {
        rankingRepository.delete(id);
    }
}
