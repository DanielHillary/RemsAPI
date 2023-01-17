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
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String coachUserName;
    private String coachTeam;
    private String email;
    private String teamState;
    private String coachResidence;
    private String coachLiceneId;
    private String photos;
}
