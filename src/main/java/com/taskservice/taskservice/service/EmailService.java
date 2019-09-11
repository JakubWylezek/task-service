package com.taskservice.taskservice.service;

import com.taskservice.taskservice.exception.custom.EmailNotFoundException;
import com.taskservice.taskservice.model.Email;
import com.taskservice.taskservice.respository.EmailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmailService {

    private EmailRepository emailRepository;

    public List<Email> getEmails() {
        return emailRepository.findAll();
    }

    public Email getEmailByName(String email) {
        return emailRepository.findByName(email).orElseThrow(() -> new EmailNotFoundException(email));
    }

    public Email addEmail(Email email) {
        return emailRepository.save(email);
    }

    public void deleteEmail(Email email) {
        emailRepository.delete(email);
    }
}
