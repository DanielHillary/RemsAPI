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
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long playerId;
    private String playerName;
    private String firstName;
    private String lastName;
    private Long teamId;
    private int age;
    private String playerPosition;
    private String stateOfOrigin;
    private String stateResidence;
    private String teamState;
    private String gender;
    private double height;
    private double weight;
    private double benchPressWeight;
    private double squotWeight;
    private String playerAddress;
    private String playerUserName;
    private String teamName;
    private String referreeName;
    private String referreeNumber;

}
