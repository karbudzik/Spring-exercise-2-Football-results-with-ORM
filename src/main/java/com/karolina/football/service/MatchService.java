package com.karolina.football.service;

import com.karolina.football.entity.Match;
import com.karolina.football.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    @Autowired
    MatchRepository matchRepository;

    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    public ResponseEntity<Object> createMatch(Match match) {
        Match savedMatch = matchRepository.save(match);
        if (matchRepository.findById(savedMatch.getId()).isPresent()) {
            return ResponseEntity.ok().body("Match created successfully!");
        } else {
            return ResponseEntity.unprocessableEntity().body("Failed to create the match specified");
        }
    }

    public Match getMatchWithMostGoals() {
        return matchRepository.getMatchWithMostGoals();
        // obsługa wyjątków
    }
}
