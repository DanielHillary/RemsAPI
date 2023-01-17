package com.jovine.nafa.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Data
public class Leagues {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long leagueId;
    private String leagueName;
    private String leagueTournament;
    private String leagueSeason;
    private String leagueGroup;
    private String district;
    private String leagueState;
    private LocalDate startDate;
    private LocalDate endDate;
}
