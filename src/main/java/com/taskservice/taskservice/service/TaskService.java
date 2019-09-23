package com.taskservice.taskservice.service;

import com.taskservice.taskservice.api.model.Email;
import com.taskservice.taskservice.api.service.EmailService;
import com.taskservice.taskservice.exception.custom.DuplicateTaskException;
import com.taskservice.taskservice.exception.custom.TaskNotFoundException;
import com.taskservice.taskservice.model.Task;
import com.taskservice.taskservice.respository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;
    private EmailService emailService;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskByName(String name) {
        return taskRepository.getByName(name).orElseThrow(() -> new TaskNotFoundException(name));
    }
    public Task addTask(Task task) {
        if(checkIfTaskExist(task.getName())) {
            throw new DuplicateTaskException(task.getName());
        }
        addNewEmails(task.getEmailList());
        sendEmailsIfTaskIsImportant(task);

        return taskRepository.save(task);
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    private Boolean checkIfTaskExist(String taskName) {
        return taskRepository.getByName(taskName).isPresent();
    }

    private void addNewEmails(List<String> emails) {
        for(String email : emails) {
            emailService.addNewEmail(new Email(email));
        }
    }

    private void sendEmailsIfTaskIsImportant(Task task) {
        if(task.isImportant()) {
            emailService.sendEmails(task);
        }
    }

}
