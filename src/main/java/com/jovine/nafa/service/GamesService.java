package com.jovine.nafa.service;

import com.jovine.nafa.entity.Games;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GamesService {
    @Autowired
    private GamesRepository gamesRepo;

    public ResponseEntity<StandardResponse> createGame(Games game) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", gamesRepo.save((game)));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not create game");
        }
    }


    public ResponseEntity<StandardResponse> getGameById(Long gameId) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", gamesRepo.findById(gameId));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false,"Could not get the game");
        }
    }


    public ResponseEntity<StandardResponse> getGamesByDate(LocalDateTime gameDate) {
        try {
            List<Games> gamesList = gamesRepo.findByGameDate(gameDate);
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get game");
        }
    }

    public ResponseEntity<StandardResponse> getGamesByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        try {
            List<Games> gamesList = gamesRepo.findByGameDateGreaterThanEqualAndGameDateLessThanEqual(startDate,endDate);
            return StandardResponse.sendHttpResponse(true, "Successful", gamesList);
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get games in this range");
        }
    }

    public ResponseEntity<StandardResponse> deleteGame(Long gameId) {
        try {
            gamesRepo.deleteById(gameId);
            return StandardResponse.sendHttpResponse(true, "Successfully deleted");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete game");
        }
    }

    public ResponseEntity<StandardResponse> deleteAllGames(){
        try {
            gamesRepo.deleteAll();
            return StandardResponse.sendHttpResponse(true, "Successfully deleted");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete all games");
        }
    }

    public ResponseEntity<StandardResponse> getGamesByState(String state) {
        try {
            List<Games> gameList = gamesRepo.findByState(state);
            return StandardResponse.sendHttpResponse(true, "Successful", gameList);
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get games for this state");
        }
    }

    public ResponseEntity<StandardResponse> getGamesByGroup(String state, String group) {
        try {
            List<Games> gamesList = gamesRepo.findByState(state);
            List<Games> groupGames = new ArrayList<>();
            for(Games g : gamesList){
                if(g.getGameGroup().equalsIgnoreCase(group)){
                    groupGames.add(g);
                }
            }
            return StandardResponse.sendHttpResponse(true, "Successful", groupGames);
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get groups by state");
        }
    }


    public ResponseEntity<StandardResponse> getGamesByDistrict(String state, String district) {
        try {
            List<Games> gamesList = gamesRepo.findByState(state);
            List<Games> districtGames = new ArrayList<>();
            for(Games g : gamesList){
                if(g.getGameDistrict().equalsIgnoreCase(district)){
                    districtGames.add(g);
                }
            }
            return StandardResponse.sendHttpResponse(true, "Successful", districtGames);
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get games by district");
        }
    }
}
