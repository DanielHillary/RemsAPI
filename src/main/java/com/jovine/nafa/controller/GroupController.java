package com.jovine.nafa.controller;

import com.jovine.nafa.entity.GroupClass;
import com.jovine.nafa.entity.Pojo.GroupRequest;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/creategroups")
    public ResponseEntity<StandardResponse> createGroup(@RequestBody GroupClass group){
        return groupService.createGroup(group);
    }

    @PostMapping("/addteamstogroup")
    public ResponseEntity<StandardResponse> addTeamsToGroup(@RequestBody GroupRequest request){
        return groupService.addTeamsToGroup(request);
    }
}
