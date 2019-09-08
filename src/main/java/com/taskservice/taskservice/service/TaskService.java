package com.taskservice.taskservice.service;

import com.taskservice.taskservice.exception.custom.TaskNotFoundException;
import com.taskservice.taskservice.model.Task;
import com.taskservice.taskservice.respository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskByName(String name) {
        return taskRepository.getByName(name).orElseThrow(() -> new TaskNotFoundException(name));
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
}
