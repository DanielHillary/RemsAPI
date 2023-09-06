package com.jovine.rems.controller;

import com.jovine.rems.entity.Lease;
import com.jovine.rems.entity.StandardResponse;
import com.jovine.rems.service.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lease")
public class LeaseController {

    @Autowired
    private LeaseService leaseService;

    @PostMapping("/createleasetype")
    public ResponseEntity<StandardResponse> createLeaseType(@RequestBody Lease lease){
        return leaseService.createLease(lease);
    }

    @GetMapping("/getleasetypes")
    public ResponseEntity<StandardResponse> getAllLease(){
        return leaseService.getAllLease();
    }

    @GetMapping("/getleaseinstate")
    public ResponseEntity<StandardResponse> getLeaseByState(@RequestParam("state") String state){
        return leaseService.getLeaseByState(state);
    }

    @PutMapping("/updatelease")
    public ResponseEntity<StandardResponse> updateLease(@RequestBody Lease lease){
        return leaseService.updateLease(lease);
    }

    @DeleteMapping("/deletelease")
    public ResponseEntity<StandardResponse> deleteLeaseById(@RequestParam("id") Long id){
        return leaseService.deleteLeaseById(id);
    }

    @DeleteMapping("/deletealllease")
    public ResponseEntity<StandardResponse> deleteAllLease(){
        return leaseService.deleteAllLease();
    }

    @PostMapping("/leaseaproperty")
    public ResponseEntity<StandardResponse> leaseAProperty(@RequestParam("leaseId") Long leaseId,
                                                           @RequestParam("propertyId") Long propertyId){
        return leaseService.leaseAProperty(leaseId, propertyId);
    }

}
