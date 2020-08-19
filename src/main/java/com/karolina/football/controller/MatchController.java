package com.karolina.football.controller;

import com.karolina.football.entity.Match;
import com.karolina.football.service.MatchService;
import com.karolina.football.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchController {
    private final MatchService matchService;
    private final TeamService teamService;

    public MatchController(MatchService matchService, TeamService teamService) {
        this.matchService = matchService;
        this.teamService = teamService;
    }

    @GetMapping("/matches/all")
    public List<Match> getMatches() {
        return matchService.getMatches();
    }

    @GetMapping("/matches/get/most-goals")
    public Match getMatchesWithMostGoals() {
        return matchService.getMatchWithMostGoals();
    }
}
