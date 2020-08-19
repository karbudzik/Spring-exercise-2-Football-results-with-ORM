package com.karolina.football.controller;

import com.karolina.football.entity.Team;
import com.karolina.football.service.MatchService;
import com.karolina.football.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TeamController {
    private TeamService teamService;
    private MatchService matchService;

    public TeamController(TeamService teamService, MatchService matchService) {
        this.teamService = teamService;
        this.matchService = matchService;
    }

    @GetMapping("/teams/all")
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/teams/get/best")
    public Team getBestTeam() {
        return teamService.getBestTeam();
    }

    @GetMapping(value = "/teams/get/containing={text}")
    public List<Team> getTeamWithTextInName(@PathVariable("text") String text) {
        return teamService.getTeamWithTextInName(text);
    }
}
