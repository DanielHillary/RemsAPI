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
public class Officials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officialId;
    private String firstName;
    private String lastName;
    private String otherName;
    private String phoneNumber;
    private String email;
    private String contactAddress;
    private String status;
    private String officialRole;
    private String category;
}
