package com.jovine.nafa.controller;

import com.jovine.nafa.entity.Player;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/registerplayer")
    public ResponseEntity<StandardResponse> registerNewPlayer(@RequestBody Player player){
        return playerService.registerNewPlayer(player);
    }

    @GetMapping("/getplayerbyid")
    public ResponseEntity<StandardResponse> getPlayerById(@RequestParam("playerId") Long playerId){
        return playerService.getPlayerById(playerId);
    }

    @GetMapping("/getallplayers")
    public ResponseEntity<StandardResponse> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @PutMapping("/updateplayer")
    public ResponseEntity<StandardResponse> updatePlayer(@RequestBody Player player){
        return playerService.updatePlayer(player);
    }

    @DeleteMapping("/deleteplayer")
    public ResponseEntity<StandardResponse> deletePlayer(@RequestParam("playerId") Long playerId){
        return playerService.deletePlayer(playerId);
    }

    @DeleteMapping("/deleteallplayers")
    public ResponseEntity<StandardResponse> deleteAllPlayers(){
        return playerService.deleteAllPlayers();
    }
}
