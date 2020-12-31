package com.fitness.authservice.controller;

import com.fitness.authservice.payload.request.LoginRequest;
import com.fitness.authservice.payload.request.SignupRequest;
import com.fitness.authservice.payload.response.JwtResponse;
import com.fitness.authservice.payload.response.MessageResponse;
import com.fitness.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Value("${auth.app.header_string}")
    private String headerString;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        HttpHeaders headers = new HttpHeaders();
        JwtResponse response = authService.authenticateUser(loginRequest);
        headers.set(headerString,response.getAccessToken());

        return ResponseEntity.ok().headers(headers).body(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        if (authService.userExistsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        String name = authService.registerUser(signUpRequest);
        return ResponseEntity.ok(new MessageResponse("User " + name + " registered successfully!"));
    }
}
