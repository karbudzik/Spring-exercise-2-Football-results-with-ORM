package com.karolina.football.service;

import com.karolina.football.entity.Match;
import com.karolina.football.repository.MatchRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    private MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

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

    public Optional<Match> getMatchWithMostGoals() {
        List<Match> matchesSorted = matchRepository.getMatchesSortedByMostGoalsTotal();
        if (matchesSorted.size() > 0) {
            return Optional.of(matchesSorted.get(0));
        } else {
            return Optional.empty();
        }
    }
}
