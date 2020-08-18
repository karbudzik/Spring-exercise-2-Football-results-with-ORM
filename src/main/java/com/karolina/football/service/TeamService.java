package com.karolina.football.service;

import com.karolina.football.entity.MatchEntity;
import com.karolina.football.entity.TeamEntity;
import com.karolina.football.repository.MatchRepository;
import com.karolina.football.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<TeamEntity> getTeams() {
        return teamRepository.findAll();
    }

    public TeamEntity getBestTeam() {
        List<TeamEntity> allTeams = teamRepository.findAll();
        return allTeams.stream()
                .max(Comparator.comparing(TeamEntity::getScore))
                .orElseThrow(NoSuchElementException::new);
    }

    public List<TeamEntity> getTeamWithTextInName(String text) {
        List<TeamEntity> allTeams = teamRepository.findAll();
        return allTeams.stream()
                .filter(a -> a.getName().toUpperCase().contains(text.toUpperCase()))
                .collect(Collectors.toList());
    }

    public ResponseEntity<Object> createTeam(TeamEntity teamEntity) {
        if (teamRepository.findByName(teamEntity.getName()).isPresent()) {
            return ResponseEntity.badRequest().body("This name is already present in the database. Names need to be unique.");
        } else {
            TeamEntity savedTeam = teamRepository.save(teamEntity);
            if (teamRepository.findById(savedTeam.getId()).isPresent()) {
                return ResponseEntity.ok("Team added successfully!");
            } else {
                return ResponseEntity.unprocessableEntity().body("Failed creating team as specified");
            }
        }
    }
}
