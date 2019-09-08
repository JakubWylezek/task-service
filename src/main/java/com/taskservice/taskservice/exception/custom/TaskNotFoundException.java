package com.taskservice.taskservice.exception.custom;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(String name) {
        super("Such task " + name + " not exist");
    }
}
