package com.jovine.nafa.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@Data
public class Standing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long standingId;
    private String league;
    private String leagueDivision;
    private String season;
    private String teamName;
    private String groupName;
    private String groupId;
    private int numberOfWins;
    private int numberOfDraws;
    private int numberOfLosses;
    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;
    private int points;
    private int tablePosition;
}
