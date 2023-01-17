package com.jovine.nafa.controller;

import com.jovine.nafa.entity.Leagues;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leagues")
public class LeagueController {
    @Autowired
    private LeagueService leagueService;

    @PostMapping("/createleague")
    public ResponseEntity<StandardResponse> createLeague(@RequestBody Leagues league){
        return leagueService.createLeague(league);
    }

    @GetMapping("getleague")
    public ResponseEntity<StandardResponse> getLeague(@RequestParam("leagueId") Long leagueId){
        return leagueService.getLeagueById(leagueId);
    }

    @GetMapping("/leaguesandteams")
    public ResponseEntity<StandardResponse> getLeagueAndTeams(@RequestParam("leagueId") Long leagueId){
        return leagueService.getLeagueAndTeams(leagueId);
    }
    @GetMapping("getleaguesbytournament")
    public ResponseEntity<StandardResponse> getLeaguesByTournament(@RequestParam("tournament") String tournament){
        return leagueService.getLeaguesByTournament(tournament);
    }

    @GetMapping("/getallleagues")
    public ResponseEntity<StandardResponse> getAllLeagues(){
        return leagueService.getAllLeagues();
    }

    @PutMapping("/updateleague")
    public ResponseEntity<StandardResponse> updateLeague(@RequestBody Leagues league){
        return leagueService.updateLeague(league);
    }
    @DeleteMapping("/deleteleague")
    public ResponseEntity<StandardResponse> deleteLeague(@RequestParam("leagueId") Long leagueId){
        return leagueService.deleteLeague(leagueId);
    }
    @DeleteMapping("/deleteallleauges")
    public ResponseEntity<StandardResponse> deleteAllLeauges(){
        return leagueService.deleteAllLeagues();
    }
}
