package com.karolina.football;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class AppController {

    @Autowired
    private TeamService teamService;

    public void fillDatabaseWithTeams() {
        TeamEntity teamEntity1 = new TeamEntity();
        TeamEntity teamEntity2 = new TeamEntity();
        TeamEntity teamEntity3 = new TeamEntity();

        teamEntity1.setName("AZS Agrosport");
        teamEntity1.setCity("Leśna Podlaska");
        teamEntity1.setCountry("Poland");

        teamEntity2.setName("Garbarnia Kurów");
        teamEntity2.setCity("Garbarnia");
        teamEntity2.setCountry("Poland");

        teamEntity3.setName("Stal Poniatowa");
        teamEntity3.setCity("Poniatowa");
        teamEntity3.setCountry("Poland");

        teamService.createTeam(teamEntity1);
        teamService.createTeam(teamEntity2);
        teamService.createTeam(teamEntity3);
    }
}
