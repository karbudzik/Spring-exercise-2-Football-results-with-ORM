package com.karolina.football.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String country;
    private String city;
    @Column(columnDefinition = "integer default 0")
    @NonNull
    private Integer score;
}
