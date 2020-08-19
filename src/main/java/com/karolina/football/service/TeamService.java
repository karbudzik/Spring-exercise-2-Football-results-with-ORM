package com.karolina.football.service;

import com.karolina.football.entity.Team;
import com.karolina.football.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isPresent()) {
            return team.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    public Team getBestTeam() {
        List<Team> allTeams = teamRepository.findAll();
        return allTeams.stream()
                .max(Comparator.comparing(Team::getScore))
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Team> getTeamWithTextInName(String text) {
        List<Team> allTeams = teamRepository.findAll();
        return allTeams.stream()
                .filter(a -> a.getName().toUpperCase().contains(text.toUpperCase()))
                .collect(Collectors.toList());
    }

    public ResponseEntity<Object> createTeam(Team team) {
        if (teamRepository.findByName(team.getName()).isPresent()) {
            return ResponseEntity.badRequest().body("This name is already present in the database. Names need to be unique.");
        } else {
            Team savedTeam = teamRepository.save(team);
            if (teamRepository.findById(savedTeam.getId()).isPresent()) {
                return ResponseEntity.ok("Team added successfully!");
            } else {
                return ResponseEntity.unprocessableEntity().body("Failed creating team as specified");
            }
        }
    }
}
