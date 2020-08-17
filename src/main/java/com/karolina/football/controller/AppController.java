package com.karolina.football.controller;

import com.karolina.football.model.TeamModel;
import com.karolina.football.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/teams/create")
    // for testing purposes (in postman)
    public ResponseEntity<Object> createTeam(@RequestBody TeamModel teamModel) {
        return teamService.createTeam(teamModel);
    }

    @PostMapping("/teams/fillDB")
    // doesn't work until the get method is provided
    public void fillDatabaseWithTeams() {
        TeamModel teamModel1 = new TeamModel();
        TeamModel teamModel2 = new TeamModel();
        TeamModel teamModel3 = new TeamModel();

        teamModel1.setName("AZS Agrosport");
        teamModel1.setCity("Leśna Podlaska");
        teamModel1.setCountry("Poland");

        teamModel2.setName("Garbarnia Kurów");
        teamModel2.setCity("Garbarnia");
        teamModel2.setCountry("Poland");

        teamModel3.setName("Stal Poniatowa");
        teamModel3.setCity("Poniatowa");
        teamModel3.setCountry("Poland");

        teamService.createTeam(teamModel1);
        teamService.createTeam(teamModel2);
        teamService.createTeam(teamModel3);
    }
}
