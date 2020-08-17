package com.karolina.football.service;

import com.karolina.football.entity.TeamEntity;
import com.karolina.football.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<TeamEntity> getTeams() {
        return teamRepository.findAll();
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
