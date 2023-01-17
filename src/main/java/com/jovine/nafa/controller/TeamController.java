package com.jovine.nafa.controller;

import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.entity.Teams;
import com.jovine.nafa.service.TeamService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
public class TeamController{
    @Autowired
    private TeamService teamService;

    @PostMapping("/createteams")
    public ResponseEntity<StandardResponse> createTeam(@RequestBody Teams team){
        return teamService.createTeam(team);
    }
    @GetMapping("/getteam")
    public ResponseEntity<StandardResponse> getTeam(@RequestParam("teamId") Long teamId){
        return teamService.getTeamById(teamId);
    }
    @GetMapping("/getallteams")
    public ResponseEntity<StandardResponse> getAllTeams(){
        return teamService.getAllTeams();
    }
    @PutMapping("/updateteam")
    public ResponseEntity<StandardResponse> updateTeamDetails(@RequestBody Teams teams){
        return teamService.updateTeamDetails(teams);
    }
    @GetMapping("/getteamsbystate")
    public ResponseEntity<StandardResponse> getTeamsByState(@RequestParam("state") String state){
        return teamService.getTeamsByState(state);
    }
    @DeleteMapping("/deleteteam")
    public ResponseEntity<StandardResponse> deleteTeam(@RequestParam("teamId") Long teamId){
        return teamService.deleteTeam(teamId);
    }
    @DeleteMapping("/deleteallteams")
    public ResponseEntity<StandardResponse> deleteAllTeams(){
        return teamService.deleteAllTeams();
    }
}
