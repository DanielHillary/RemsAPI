package com.jovine.rems.controller;

import com.jovine.rems.entity.Pojo.LoginRequest;
import com.jovine.rems.entity.StandardResponse;
import com.jovine.rems.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService jwtService;

    @PostMapping({"/login"})
    public ResponseEntity<StandardResponse> createJwtToken(@RequestBody LoginRequest login) throws Exception {
        return StandardResponse.sendHttpResponse(true, "Successful Operation",
                jwtService.createJwtToken(login), "200");
    }
}
