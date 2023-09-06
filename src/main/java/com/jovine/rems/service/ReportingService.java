package com.jovine.rems.service;

import com.jovine.rems.entity.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReportingService {


    public ResponseEntity<StandardResponse> generateReportForTenant(Long tenantId) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not generate report");
        }
    }
}
