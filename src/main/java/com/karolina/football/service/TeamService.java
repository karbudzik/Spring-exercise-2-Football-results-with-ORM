package com.karolina.football.service;

import com.karolina.football.entity.TeamEntity;
import com.karolina.football.repository.TeamRepository;
import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public ResponseEntity<Object> createTeam(@NotNull TeamEntity newTeam) {
        if (teamRepository.findByName(newTeam.getName()).isPresent()) {
            return ResponseEntity.badRequest().body("The team with this name is already in our database");
        } else {
            teamRepository.save(newTeam);
            return ResponseEntity.ok("Team added successfully");
        }
    }
}
