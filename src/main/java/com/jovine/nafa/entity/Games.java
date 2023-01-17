package com.jovine.nafa.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@RequiredArgsConstructor
@Data
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gamesId;
    private String gamesTag;
    private String homeTeam;
    private String awayTeam;
    private LocalDateTime gameDate;
    private LocalTime gameTime;
    private String state;
    private String gameSeason;
    private String gameGroup;
    private String gameGender;
    private String groupGender;
    private String gameDistrict;
    private int homeTeamScore;
    private int awayTeamScore;
    private String referee;
    private String awayTeamCoach;
    private String homeTeamCoach;
    private String halfs;
    private String status;
}
