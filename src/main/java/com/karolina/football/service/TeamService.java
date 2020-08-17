package com.karolina.football.service;

import com.karolina.football.entity.TeamEntity;
import com.karolina.football.model.TeamModel;
import com.karolina.football.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public ResponseEntity<Object> createTeam(TeamModel teamModel) {
        TeamEntity teamEntity = new TeamEntity();
        if (teamRepository.findByName(teamModel.getName()).isPresent()) {
            return ResponseEntity.badRequest().body("This name is already present in the database. Names need to be unique.");
        } else {
            teamEntity.setName(teamModel.getName());
            teamEntity.setCity(teamModel.getCity());
            teamEntity.setCountry(teamModel.getCountry());

            TeamEntity savedTeam = teamRepository.save(teamEntity);
            if (teamRepository.findById(savedTeam.getId()).isPresent()) {
                return ResponseEntity.ok("Team added successfully!");
            } else {
                return ResponseEntity.unprocessableEntity().body("Failed creating team as specified");
            }
        }
    }
}
