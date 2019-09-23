package com.taskservice.taskservice.exception.custom;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DuplicateTaskException extends RuntimeException {

    public DuplicateTaskException(String taskName) {
        super("Such task  " + taskName + " exist");
    }
}
