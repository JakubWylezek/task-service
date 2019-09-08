package com.taskservice.taskservice.controller;

import com.taskservice.taskservice.model.Task;
import com.taskservice.taskservice.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks() {
        return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
    }

    @GetMapping("/tasks/{name}")
    public ResponseEntity<Task> getTaskByName(@PathVariable String name) {
        return new ResponseEntity<>(taskService.getTaskByName(name), HttpStatus.OK);
    }

    @PostMapping("/tasks")
    public ResponseEntity addTask(@RequestBody Task task) {
        try {
            taskService.addTask(task);
            return ResponseEntity.created(new URI("/tasks/" + task.getName())).build();
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping
    public ResponseEntity deleteTask(@RequestBody Task task) {
        taskService.deleteTask(task);
        return ResponseEntity.ok().build();
    }
}
