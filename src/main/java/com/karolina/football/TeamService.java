package com.karolina.football;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
