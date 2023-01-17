package com.jovine.nafa.controller;

import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.entity.Standing;
import com.jovine.nafa.service.StandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/standing")
public class StandingController {
    @Autowired
    private StandingService standingService;

    @PostMapping("/createstanding")
    public ResponseEntity<StandardResponse> createStanding(@RequestBody Standing standing){
        return standingService.createStanding(standing);
    }
    @GetMapping("/getstanding")
    public ResponseEntity<StandardResponse> getStanding(@RequestParam("standingId") Long standingId){
        return standingService.getStanding(standingId);
    }
    @GetMapping("/getallstanding")
    public ResponseEntity<StandardResponse> getAllStanding(){
        return standingService.getAllStandings();
    }
    @PutMapping("/updatestanding")
    public ResponseEntity<StandardResponse> updateStanding(@RequestBody Standing standing){
        return standingService.updateStandingDetails(standing);
    }
    @DeleteMapping("/deletestanding")
    public ResponseEntity<StandardResponse> deleteStanding(@RequestParam("standingId") Long standingId){
        return standingService.deleteStanding(standingId);
    }
    @DeleteMapping("/deleteallstandings")
    public ResponseEntity<StandardResponse> deleteAllStandings(){
        return standingService.deleteAllStandings();
    }
}
