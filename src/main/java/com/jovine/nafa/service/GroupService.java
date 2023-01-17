package com.jovine.nafa.service;

import com.jovine.nafa.entity.GroupClass;
import com.jovine.nafa.entity.Pojo.GroupRequest;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.entity.Teams;
import com.jovine.nafa.repository.GroupsRepo;
import com.jovine.nafa.repository.TeamsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    private TeamsRepo teamsRepo;
    @Autowired
    private GroupsRepo groupsRepo;

    public ResponseEntity<StandardResponse> addTeamsToGroup(GroupRequest request) {
        try {
            List<String> teamNames = new ArrayList<>();
            List<Teams> teamsList = new ArrayList<>();
            for(String name : teamNames){
                Teams teams = teamsRepo.findByTeamName(name).get();
                teams.setTeamGroup(request.getGroupLetter());
                teamsList.add(teams);
                teamsRepo.save(teams);
            }
            return StandardResponse.sendHttpResponse(true,"Successful", teamsList);
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not add to group");
        }
    }

    public ResponseEntity<StandardResponse> createGroup(GroupClass group) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", groupsRepo.save(group));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not creat group");
        }
    }
}
