package com.fitness.authservice.controller;

import com.fitness.authservice.exception.RequestException;
import com.fitness.authservice.payload.request.LoginRequest;
import com.fitness.authservice.payload.request.SignupRequest;
import com.fitness.authservice.payload.response.JwtResponse;
import com.fitness.authservice.payload.response.MessageResponse;
import com.fitness.authservice.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        Logger logger = LoggerFactory.getLogger(AuthController.class);


    @Autowired
    private AuthService authService;

    @Value("${auth.app.header_string}")
    private String headerString;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws RequestException {
        HttpHeaders headers = new HttpHeaders();
        JwtResponse response = authService.authenticateUser(loginRequest);
        headers.set(headerString, response.getAccessToken());

        return ResponseEntity.ok().headers(headers).body(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) throws RequestException {
        String name = authService.registerUser(signUpRequest);
        return ResponseEntity.ok(new MessageResponse("User " + name + " registered successfully!"));
    }
}
