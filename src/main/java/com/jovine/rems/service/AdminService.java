package com.jovine.rems.service;

import com.jovine.rems.entity.AdminUser;
import com.jovine.rems.entity.Role;
import com.jovine.rems.entity.StandardResponse;
import com.jovine.rems.entity.User;
import com.jovine.rems.repository.AdminRepository;
import com.jovine.rems.repository.RoleRepository;
import com.jovine.rems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private NotifyService NService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<StandardResponse> registerNewAdmin(AdminUser adminUser) {
        try {
            Role role = roleRepo.findByRoleName("Admin").get();
            Set<Role> roles = new HashSet<>();
            roles.add(role);

            Random customerRand = new Random();
            String vOtp = String.format("%04d", customerRand.nextInt(10000));

            boolean loggedUser = userRepo.findByUserName(adminUser.getUserName()).isPresent();
            if(!loggedUser) {
                adminUser.setUserId(String.format("%04d", customerRand.nextInt(10000)));
                adminUser.setRole(roles);
                adminUser.setTag("Admin");
                adminUser.setPassword(passwordEncoder.encode(adminUser.getPassword()));

                User user = new User();
                user.setEmail(adminUser.getEmail());
                user.setUserName(adminUser.getUserName());
                user.setPhoneNumber(adminUser.getPhoneNumber());
                user.setUserFirstName(adminUser.getFirstName());
                user.setUserLastName(adminUser.getLastName());
                user.setUserId(adminUser.getUserId());
                user.setRole(adminUser.getRole());
                user.setTag("Admin");
                user.setUserPassword(passwordEncoder.encode(adminUser.getPassword()));

                NService.sendNotificationOTP(user, "Thank you for signing up. <br /> Use the following OTP to Validate your email <strong> " + vOtp + "</strong>" );
                NService.sendRegistrationNotification(user);

                userRepo.save(user);
                AdminUser savedUser = adminRepository.save(adminUser);
                return StandardResponse.sendHttpResponse(true, "Operation successful!", savedUser, "200");
            }else{
                return StandardResponse.sendHttpResponse(false, "User already exists");
            }
        } catch (Exception e) {

            return StandardResponse.sendHttpResponse(false, "Could not save user");
        }
    }

    public ResponseEntity<StandardResponse> getAllAdmins() {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", adminRepository.findAll());
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get all admins");
        }
    }

    public ResponseEntity<StandardResponse> updateAdmin(AdminUser admin) {
        try {
            User user = userRepo.findByUserId(admin.getUserId()).get();
            user.setUserName(admin.getUserName());
            userRepo.save(user);
            //update the equivalent user
            return StandardResponse.sendHttpResponse(true, "Successful", adminRepository.save(admin));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return StandardResponse.sendHttpResponse(false, "Could not update admin");
        }
    }

    public ResponseEntity<StandardResponse> deleteAdmin(Long id) {
        try {
            User user = userRepo.findByUserId(adminRepository.findById(id).get().getUserId()).get();
            userRepo.delete(user);
            adminRepository.deleteById(id);
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete user");
        }
    }
}
