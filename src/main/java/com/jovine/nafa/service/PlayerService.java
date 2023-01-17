package com.jovine.nafa.service;

import com.jovine.nafa.entity.Player;
import com.jovine.nafa.entity.Role;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.entity.User;
import com.jovine.nafa.repository.PlayerRepository;
import com.jovine.nafa.repository.RoleRepository;
import com.jovine.nafa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class PlayerService {

    @Autowired
    private RoleRepository  roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlayerRepository playerRepository;

    public ResponseEntity<StandardResponse> registerNewPlayer(Player player) {
        try {
            User user = new User();
            user.setEmail(player.getEmail());
            user.setUserFirstName(player.getFirstName());
            user.setUserLastName(player.getLastName());
            user.setPhoneNumber(player.getPhoneNumber());
            user.setUserName(player.getPlayerUserName());

            Role role = roleRepository.findByRoleName("Player").get();
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRole(roles);
            user.setTag("Player");

            userRepository.save(user);
            return StandardResponse.sendHttpResponse(true, "Successful", playerRepository.save(player));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not register Player");
        }
    }

    public ResponseEntity<StandardResponse> getPlayerById(Long playerId) {
        try {
            Player play = playerRepository.findById(playerId).get();
            return StandardResponse.sendHttpResponse(true, "Successful", play);
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get players");
        }
    }

    public ResponseEntity<StandardResponse> getAllPlayers() {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", playerRepository.findAll());
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get all players");
        }
    }

    public ResponseEntity<StandardResponse> updatePlayer(Player player) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", playerRepository.save(player));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not update player");
        }
    }

    public ResponseEntity<StandardResponse> deletePlayer(Long playerId) {
        try {
            playerRepository.deleteById(playerId);
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete Player");
        }
    }

    public ResponseEntity<StandardResponse> deleteAllPlayers(){
        try {
            playerRepository.deleteAll();
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete all players");
        }
    }
}
