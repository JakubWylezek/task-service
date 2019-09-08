package com.taskservice.taskservice.controller;

import com.taskservice.taskservice.model.Email;
import com.taskservice.taskservice.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class EmailController {

    private EmailService emailService;

    @GetMapping("/emails")
    public ResponseEntity<List<Email>> getEmails() {
        return new ResponseEntity<>(emailService.getEmails(), HttpStatus.OK);
    }

    @GetMapping("/emails/{email}")
    public ResponseEntity<Email> getEmailByName(@PathVariable String email) {
        return new ResponseEntity<>(emailService.getEmailByName(email), HttpStatus.OK);
    }

    @PostMapping("/emails")
    public ResponseEntity<Email> addEmail(@RequestBody @Valid Email email, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.MULTI_STATUS).build();
        }
        return new ResponseEntity<>(emailService.addEmail(email), HttpStatus.CREATED);
    }

    @DeleteMapping("/emails")
    public ResponseEntity deleteEmail(@RequestBody Email email) {
        emailService.deleteEmail(email);
        return ResponseEntity.ok().build();
    }
}
