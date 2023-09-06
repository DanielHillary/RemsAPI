package com.jovine.rems.service;

import com.jovine.rems.entity.Lease;
import com.jovine.rems.entity.Property;
import com.jovine.rems.entity.StandardResponse;
import com.jovine.rems.repository.LeaseRepository;
import com.jovine.rems.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaseService {

    @Autowired
    private LeaseRepository leaseRepository;
    @Autowired
    private PropertyRepository propertyRepository;

    public ResponseEntity<StandardResponse> createLease(Lease lease) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", leaseRepository.save(lease));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not create lease");
        }
    }

    public ResponseEntity<StandardResponse> getAllLease() {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", leaseRepository.findAll());
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get all lease");
        }
    }

    public ResponseEntity<StandardResponse> getLeaseByState(String state) {
        try {
            List<Lease> leases = leaseRepository.findByState(state);
            return StandardResponse.sendHttpResponse(true, "Successful", leases);
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get all lease");
        }
    }

    public ResponseEntity<StandardResponse> updateLease(Lease lease) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", leaseRepository.save(lease));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not create lease");
        }
    }

    public ResponseEntity<StandardResponse> deleteLeaseById(Long id) {
        try {
            leaseRepository.deleteById(id);
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not create lease");
        }
    }

    public ResponseEntity<StandardResponse> deleteAllLease() {
        try {
            leaseRepository.deleteAll();
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not create lease");
        }
    }

    public ResponseEntity<StandardResponse> leaseAProperty(Long leaseId, Long propertyId) {
        try {
            Property property = propertyRepository.findById(propertyId).get();
            Lease lease = leaseRepository.findById(leaseId).get();

            property.setLeaseTenure(lease.getLeaseTenure());
            property.setOnLease(true);

            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not lease property");
        }
    }
}
