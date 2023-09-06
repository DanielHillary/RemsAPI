package com.jovine.rems.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String propertyId;
    private Long leaseId;
    private String LGA;
    private String propertyType;
    private String propertyName;
    private String state;
    private boolean isOnLease;
    private String estateName;
    private String photo;
    private int leaseTenure;
    private double leaseAmountPerMonth;
    private double leaseAmountPerAnnum;
    private boolean isSold;
    private String category;
    private String country;
}
