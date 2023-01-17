package com.jovine.nafa.controller;

import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.entity.Tournament;
import com.jovine.nafa.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tournament")
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/createtournament")
    public ResponseEntity<StandardResponse> createTournament(@RequestBody Tournament tournament){
        return tournamentService.createTournament(tournament);
    }
    @GetMapping("/gettournament")
    public ResponseEntity<StandardResponse> getTournament(@RequestParam("id") Long id){
        return tournamentService.getTournament(id);
    }
    @GetMapping("/getalltournament")
    public ResponseEntity<StandardResponse> getTournaments(){
        return tournamentService.getAllTournament();
    }
    @DeleteMapping("/deletetournament")
    public ResponseEntity<StandardResponse> deleteTournament(@RequestParam("id") Long id){
        return tournamentService.deleteTournament(id);
    }
    @DeleteMapping("/deletealltournament")
    public ResponseEntity<StandardResponse> deleteAll(){
        return tournamentService.deleteAll();
    }
}
