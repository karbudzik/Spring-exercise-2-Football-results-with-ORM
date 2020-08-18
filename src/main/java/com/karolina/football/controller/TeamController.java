package com.karolina.football.controller;

import com.karolina.football.entity.TeamEntity;
import com.karolina.football.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostConstruct
    public void init() {
        fillDatabaseWithTeams();
    }

    @GetMapping("/teams/all")
    public List<TeamEntity> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/teams/get/best")
    public TeamEntity getBestTeam() {
        return teamService.getBestTeam();
    }

    @GetMapping(value = "/teams/get/containing/{text}")
    public List<TeamEntity> getTeamWithTextInName(@PathVariable("text") String text) {
        return teamService.getTeamWithTextInName(text);
    }

    private void fillDatabaseWithTeams() {
        TeamEntity teamEntity1 = new TeamEntity();
        TeamEntity teamEntity2 = new TeamEntity();
        TeamEntity teamEntity3 = new TeamEntity();

        teamEntity1.setName("AZS Agrosport");
        teamEntity1.setCity("Leśna Podlaska");
        teamEntity1.setCountry("Poland");
        teamEntity1.setScore(5);

        teamEntity2.setName("Garbarnia Kurów");
        teamEntity2.setCity("Garbarnia");
        teamEntity2.setCountry("Poland");
        teamEntity2.setScore(1);

        teamEntity3.setName("Stal Poniatowa");
        teamEntity3.setCity("Poniatowa");
        teamEntity3.setCountry("Poland");
        teamEntity3.setScore(8);

        teamService.createTeam(teamEntity1);
        teamService.createTeam(teamEntity2);
        teamService.createTeam(teamEntity3);
    }
}
