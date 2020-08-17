package com.karolina.football;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "teams")
public class TeamEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String country;
    private String city;
}
