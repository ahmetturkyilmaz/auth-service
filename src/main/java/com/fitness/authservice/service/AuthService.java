package com.fitness.authservice.service;

import com.fitness.authservice.exception.RequestValidationException;
import com.fitness.authservice.model.ERole;
import com.fitness.authservice.model.Role;
import com.fitness.authservice.model.User;
import com.fitness.authservice.payload.request.LoginRequest;
import com.fitness.authservice.payload.request.SignupRequest;
import com.fitness.authservice.payload.response.JwtResponse;
import com.fitness.authservice.repository.RoleRepository;
import com.fitness.authservice.repository.UserRepository;
import com.fitness.authservice.security.jwt.JwtUtils;
import com.fitness.authservice.security.services.UserDetailsImpl;
import com.fitness.authservice.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserValidator userValidator;

    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = getJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getName(),
                userDetails.getSurname(),
                roles);
    }

    public String getJwtToken(Authentication authentication) {
        return jwtUtils.generateJwtToken(authentication);
    }

    public boolean userExistsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }


    public String registerUser(SignupRequest signUpRequest) throws RequestValidationException {
        // Create new user's account

        User user = new User(signUpRequest.getEmail(), signUpRequest.getName(), signUpRequest.getSurname(), signUpRequest.getPassword());
        userValidator.validateUser(user);
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        user.setCreatedAt(new Date());
        return userRepository.save(user).getEmail();
    }
}
