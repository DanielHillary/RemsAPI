package com.jovine.rems.controller;

import com.jovine.rems.entity.StandardResponse;
import com.jovine.rems.entity.User;
import com.jovine.rems.service.UserService;
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

//    @PostMapping("/uploadphoto")
//    public ResponseEntity<StandardResponse> uploadPhoto(@RequestParam("image")MultipartFile multipartFile){
//        return userService.uploadPhoto(multipartFile);
//    }

    @PostMapping("/registeradmin")
    public ResponseEntity<StandardResponse> registerAdmin(@RequestBody User adminUser){
        return userService.registerNewAdmin(adminUser);
    }

    @GetMapping("/getallusers")
    public ResponseEntity<StandardResponse> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/getuser")
    public ResponseEntity<StandardResponse> getUser(@RequestParam("userId") Long userId){
        return userService.getUser(userId);
    }

    @DeleteMapping("/deleteuser")
    public ResponseEntity<StandardResponse> deleteUser(@RequestParam("userId") Long userId){
        return userService.deleteUser(userId);
    }

    @DeleteMapping("/deleteallusers")
    public ResponseEntity<StandardResponse> deleteAllUsers(){
        return userService.deleteAllUsers();
    }

    @PutMapping("/updateuser")
    public ResponseEntity<StandardResponse> updateUser(@RequestBody User user){
        return userService.updateUser(user);
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
