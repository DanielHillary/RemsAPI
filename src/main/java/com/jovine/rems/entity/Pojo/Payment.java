package com.jovine.rems.entity.Pojo;

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
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenantId;
    private String bankName;
    private String tenantName;
    private Long propertyId;
    private double amountPaid;
    private LocalDateTime paymentDate;
    private String paymentType;
    private String reasonForPayment;
    private String invoiceId;
    private boolean hasBalance;
    private boolean isNewPayment;
}
