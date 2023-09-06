package com.jovine.rems.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Data
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String userName;
    private String nationality;
    private String maritalStatus;
    private String occupation;
    private String propertyName;
    private String propertyId;
    private String isOnLease;
    private int leaseTenure;
    private LocalDateTime subscriptionDate;
    private LocalDateTime expirationDate;

}
