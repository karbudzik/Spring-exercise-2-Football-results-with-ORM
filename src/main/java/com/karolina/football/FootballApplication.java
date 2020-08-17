package com.karolina.football;

import com.karolina.football.controller.AppController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FootballApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballApplication.class, args);
        AppController controller = new AppController();
        controller.fillDatabaseWithTeams();
    }

}
