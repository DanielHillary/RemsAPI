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
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teamId;
    private String teamName;
    private String teamState;
    private String teamLeague;
    private String teamGender;
    private String genderGroup;
    private String teamGroup;
    private String teamDistrict;
    private Long leagueId;
    private String teamCoach;
    private Long coachId;
}
