package com.jovine.rems.controller;

import com.jovine.rems.entity.StandardResponse;
import com.jovine.rems.service.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reporting")
public class ReportController {

    @Autowired
    private ReportingService reportingService;

    @GetMapping("/generatereport")
    public ResponseEntity<StandardResponse> generateReportForTenant(@RequestParam("tenantId") Long tenantId){
        return reportingService.generateReportForTenant(tenantId);
    }


}
