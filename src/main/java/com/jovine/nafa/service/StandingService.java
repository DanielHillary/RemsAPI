package com.jovine.nafa.service;

import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.entity.Standing;
import com.jovine.nafa.repository.StandingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StandingService {
    @Autowired
    private StandingRepo standingRepo;

    public ResponseEntity<StandardResponse> createStanding(Standing standing) {
        return null;
    }

    public ResponseEntity<StandardResponse> getStanding(Long standingId) {
        return null;
    }

    public ResponseEntity<StandardResponse> getAllStandings() {
        return null;
    }

    public ResponseEntity<StandardResponse> updateStandingDetails(Standing standing) {
        return null;
    }

    public ResponseEntity<StandardResponse> deleteStanding(Long standingId) {
        return null;
    }

    public ResponseEntity<StandardResponse> deleteAllStandings() {
        return null;
    }
}
