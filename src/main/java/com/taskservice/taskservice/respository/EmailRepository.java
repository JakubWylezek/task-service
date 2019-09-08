package com.taskservice.taskservice.respository;

import com.taskservice.taskservice.model.Email;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailRepository extends MongoRepository<Email, String> {

    Optional<Email> findByEmail(String email);
}
