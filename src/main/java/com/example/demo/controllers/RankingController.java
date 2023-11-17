package com.example.demo.controllers;

import com.example.demo.entities.Ranking;
import com.example.demo.servicesTest.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rankings")
public class RankingController {
    @Autowired
    private RankingService rankingService;

    @GetMapping
    public List<Ranking> findAll() {
        return rankingService.findAll();
    }

    @GetMapping("/{id}")
    public Ranking findById(@PathVariable Long id) {
        return rankingService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Ranking ranking) {
        rankingService.save(ranking);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Ranking ranking) {
        if (id.equals(ranking.getId())) {
            rankingService.update(ranking);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        rankingService.delete(id);
    }
}
