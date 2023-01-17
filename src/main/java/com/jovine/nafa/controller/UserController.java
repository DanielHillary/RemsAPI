package com.jovine.nafa.controller;

import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.entity.User;
import com.jovine.nafa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/registration")
public class UserController {

    @Autowired
    private UserService userService;


//    @PostConstruct
//    public void initRoleAndUser() {
//        userService.initRoleAndUser();
//    }

//    @PostConstruct
//    public void getWatchedPrices(){
//        calculationService.getWatchedPrices();
//    }

    @PostMapping({"/registerNewUser"})
    public ResponseEntity<StandardResponse> registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @PostMapping("/uploadphoto")
    public ResponseEntity<StandardResponse> uploadPhoto(@RequestParam("image")MultipartFile multipartFile){
        return userService.uploadPhoto(multipartFile);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
}
