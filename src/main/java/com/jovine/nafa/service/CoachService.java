package com.jovine.nafa.service;

import com.jovine.nafa.entity.Coach;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.repository.CoachRepository;
import com.jovine.nafa.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class CoachService {
    @Autowired
    private CoachRepository coachRepository;

    private Coach user;

    public ResponseEntity<StandardResponse> createCoach(Coach coach) {
        try {
            user = coachRepository.save(coach);
            return StandardResponse.sendHttpResponse(true, "Successful", coachRepository.save(coach));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not create coach");
        }
    }

    public ResponseEntity<StandardResponse> getCoach(Long coachId){
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", coachRepository.findById(coachId));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Coulc not get Coach details");
        }
    }

    public ResponseEntity<StandardResponse> getAllCoaches(){
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", coachRepository.findAll());
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get all coaches");
        }
    }

    public ResponseEntity<StandardResponse> updateCoachDetails(Coach coach){
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", coachRepository.save(coach));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not update coach details");
        }
    }

    public ResponseEntity<StandardResponse> deleteCoach(Long coachId){
        try {
            coachRepository.deleteById(coachId);
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete coach");
        }
    }

    public ResponseEntity<StandardResponse> deleteAllCoaches(){
        try {
            coachRepository.deleteAll();
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete All coaches");
        }
    }

    public ResponseEntity<StandardResponse> uploadPhoto(MultipartFile multipartFile) throws IOException {
        try {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

            user.setPhotos(fileName);
            Coach savedUser = coachRepository.save(user);
            String uploadDir = "user-photos/" + savedUser.getCoachId();

            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            System.out.println("Upload successfully");
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not upload image file");
        }
    }
}
