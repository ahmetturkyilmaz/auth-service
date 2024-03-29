package com.fitness.authservice.repository;

import com.fitness.authservice.model.ERole;
import com.fitness.authservice.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    @Query("{name:?0}")
    Optional<Role> findByName(ERole name);
}
