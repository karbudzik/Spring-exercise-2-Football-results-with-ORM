package com.karolina.football.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "matches")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @OneToOne(targetEntity = TeamEntity.class, cascade = CascadeType.ALL)
    private TeamEntity homeTeamEntity;
    @OneToOne(targetEntity = TeamEntity.class, cascade = CascadeType.ALL)
    private TeamEntity awayTeamEntity;
    private Integer goalsHome;
    private Integer goalsAway;
}
