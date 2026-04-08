package com.example.hello_world;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AuthUserRepository extends MongoRepository<AuthUser, String> {

    Optional<AuthUser> findByUsername(String username);

    boolean existsByUsername(String username);
}
