package com.jovine.nafa.service;

import com.jovine.nafa.entity.Coach;
import com.jovine.nafa.entity.Role;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.entity.User;
import com.jovine.nafa.repository.CoachRepository;
import com.jovine.nafa.repository.RoleRepository;
import com.jovine.nafa.repository.UserRepository;
import com.jovine.nafa.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class CoachService {
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    private Coach coachs;


    public ResponseEntity<StandardResponse> createCoach(Coach coach) {
        try {
            User user = new User();
            user.setEmail(coach.getEmail());
            user.setUserFirstName(coach.getFirstName());
            user.setUserLastName(coach.getLastName());
            user.setPhoneNumber(coach.getPhoneNumber());
            user.setUserName(coach.getCoachUserName());

            Role role = roleRepository.findByRoleName("Player").get();
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRole(roles);
            user.setTag("Player");

            userRepository.save(user);
            coachs = coachRepository.save(coach);
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

            coachs.setPhotos(fileName);
            Coach savedUser = coachRepository.save(coachs);
            String uploadDir = "user-photos/" + savedUser.getCoachId();

            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            System.out.println("Upload successfully");
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not upload image file");
        }
    }
}
