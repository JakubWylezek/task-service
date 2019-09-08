package com.taskservice.taskservice.model;

import com.taskservice.taskservice.constraints.EmailValidation;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("email")
@NoArgsConstructor
public class Email {

    @Id
    private String id;
    @EmailValidation
    private String email;

    public Email(String name) {
        this.email = name;
    }
}
