package com.karolina.football.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @OneToOne(targetEntity = Team.class, cascade = CascadeType.ALL)
    private Team homeTeam;
    @OneToOne(targetEntity = Team.class, cascade = CascadeType.ALL)
    private Team awayTeam;
    private Integer goalsHome;
    private Integer goalsAway;
}
