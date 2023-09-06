package com.jovine.rems.entity.Pojo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Data
public class ReportingResponse {

    private String tenantName;
    private String propertyId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
