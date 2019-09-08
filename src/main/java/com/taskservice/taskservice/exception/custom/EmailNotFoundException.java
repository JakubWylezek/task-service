package com.taskservice.taskservice.exception.custom;

public class EmailNotFoundException extends RuntimeException {

    public EmailNotFoundException(String email) {
        super("Such email " + email + " not exist");
    }
}
