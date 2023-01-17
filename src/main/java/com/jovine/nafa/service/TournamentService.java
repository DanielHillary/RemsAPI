package com.jovine.nafa.service;

import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.entity.Tournament;
import com.jovine.nafa.repository.TournamentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepo tournamentRepo;

    public ResponseEntity<StandardResponse> createTournament(Tournament tournament) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", tournamentRepo.save(tournament));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not createTournament");
        }
    }

    public ResponseEntity<StandardResponse> getTournament(Long id) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", tournamentRepo.findById(id));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get Tournament");
        }
    }

    public ResponseEntity<StandardResponse> getAllTournament() {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", tournamentRepo.findAll());
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get Tournament");
        }
    }

    public ResponseEntity<StandardResponse> deleteTournament(Long id) {
        try {
            tournamentRepo.deleteById(id);
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete Tournament");
        }
    }

    public ResponseEntity<StandardResponse> deleteAll() {
        try {
            tournamentRepo.deleteAll();
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete all Tournaments");
        }
    }
}
