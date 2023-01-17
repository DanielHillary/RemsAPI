package com.jovine.nafa.controller;

import com.jovine.nafa.entity.Coach;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/coaches")
public class CoachController {
    @Autowired
    private CoachService coachService;

    @PostMapping("/createcoach")
    public ResponseEntity<StandardResponse> createCoach(@RequestBody Coach coach){
        return coachService.createCoach(coach);
    }
    @GetMapping("/getcoach")
    public ResponseEntity<StandardResponse> getCoach(@RequestParam("coachId") Long coachId){
        return coachService.getCoach(coachId);
    }
    @GetMapping("/getallcoaches")
    public ResponseEntity<StandardResponse> getAllCoaches(){
        return coachService.getAllCoaches();
    }
    @PutMapping("/updatecoachdetails")
    public ResponseEntity<StandardResponse> updateCoachDetails(@RequestBody Coach coach){
        return coachService.updateCoachDetails(coach);
    }
    @DeleteMapping("/deletecoach")
    public ResponseEntity<StandardResponse> deleteCoach(@RequestParam("coachId") Long coachId){
        return coachService.deleteCoach(coachId);
    }
    @DeleteMapping("/deleteallcoaches")
    public ResponseEntity<StandardResponse> deleteAllCoaches(){
        return coachService.deleteAllCoaches();
    }

    @PostMapping("/uploadpicture")
    public ResponseEntity<StandardResponse> uploadCoachPicture (@RequestParam("image") MultipartFile multipartFile ) throws IOException {
        return coachService.uploadPhoto(multipartFile);
    }
}
