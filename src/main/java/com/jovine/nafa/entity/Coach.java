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
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long coachId;
    private String coachName;
    private String coachTeam;
    private String teamState;
    private String coachResidence;
    private String coachNumber;
    private String photos;
    private String email;
}
