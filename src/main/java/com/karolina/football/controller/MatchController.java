package com.karolina.football.controller;

import com.karolina.football.entity.Match;
import com.karolina.football.service.MatchService;
import com.karolina.football.service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class MatchController {
    private final MatchService matchService;
    private final TeamService teamService;

    public MatchController(MatchService matchService, TeamService teamService) {
        this.matchService = matchService;
        this.teamService = teamService;
    }

    @GetMapping("/matches")
    public List<Match> getMatches() {
        return matchService.getMatches();
    }

    @GetMapping("/matches/most-goals")
    public Match getMatchesWithMostGoals() {
        Optional<Match> matchOptional = matchService.getMatchWithMostGoals();
        if (matchOptional.isPresent()) {
            return matchOptional.get();
        } else {
            throw new NoSuchElementException();
        }
    }
}
