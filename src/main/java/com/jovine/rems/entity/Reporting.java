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
public class Reporting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenantsName;
    private String propertyId;
    private int tenancyTenure;
    private LocalDateTime expirationDate;
    private LocalDateTime subscriptionDate;
    private int years;
    private int months;
    private String location;
    private int occupancy;
    private double leaseAmount;
}
