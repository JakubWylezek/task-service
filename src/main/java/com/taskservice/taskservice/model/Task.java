package com.taskservice.taskservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("task")
@NoArgsConstructor
public class Task {

    @Id
    private String id;
    private String name;
    private String description;
    private boolean isImportant;
    private List<Email> emailList;

    public Task(String name, String description, boolean isImportant, List<Email> emailList) {
        this.name = name;
        this.description = description;
        this.isImportant = isImportant;
        this.emailList = emailList;
    }
}
