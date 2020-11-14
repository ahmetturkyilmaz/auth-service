package com.fitness.authservice.config;

import com.fitness.authservice.model.ERole;
import com.fitness.authservice.model.Role;
import com.fitness.authservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
public class InitialDBConfig {
    @Autowired
    RoleRepository roleRepository;

    @PostConstruct
    private void checkIfRolesExist() {
        Optional<Role> userRole = roleRepository.findByName(ERole.ROLE_USER);
        Optional<Role> modRole = roleRepository.findByName(ERole.ROLE_MODERATOR);
        Optional<Role> adminRole = roleRepository.findByName(ERole.ROLE_ADMIN);

        if (!userRole.isPresent()) {
            roleRepository.save(new Role(ERole.ROLE_USER));
        }
        if (!modRole.isPresent()) {
            roleRepository.save(new Role(ERole.ROLE_MODERATOR));
        }
        if (!adminRole.isPresent()) {
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
        }

    }

}
