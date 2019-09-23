package com.taskservice.taskservice.service;

import com.taskservice.taskservice.api.model.Email;
import com.taskservice.taskservice.api.service.EmailService;
import com.taskservice.taskservice.exception.custom.DuplicateTaskException;
import com.taskservice.taskservice.exception.custom.TaskNotFoundException;
import com.taskservice.taskservice.model.Task;
import com.taskservice.taskservice.respository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;
    private EmailService emailService;

    public List<Task> getTasks() {
        log.info("Invoke TaskService getTasks method");
        return taskRepository.findAll();
    }

    public Task getTaskByName(String name) {
        log.info("Invoke TaskService getTaskByName method with " + name + " task name parameter");
        return taskRepository.getByName(name).orElseThrow(() -> new TaskNotFoundException(name));
    }

    public Task addTask(Task task) {
        log.info("Invoke TaskService addTask method");
        if(checkIfTaskExist(task.getName())) {
            log.warn("Duplicate task " + task.toString());
            throw new DuplicateTaskException(task.getName());
        }
        addNewEmails(task.getEmailList());
        sendEmailsIfTaskIsImportant(task);
        log.info("Save task to database " + task.toString());
        return taskRepository.save(task);
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
        log.info("Task " + task.toString() + " was deleted");
    }

    private Boolean checkIfTaskExist(String taskName) {
        return taskRepository.getByName(taskName).isPresent();
    }

    private void addNewEmails(List<String> emails) {
        for(String email : emails) {
            emailService.addNewEmail(new Email(email));
            log.info("Email " + email + " was send to email-service");
        }
    }

    private void sendEmailsIfTaskIsImportant(Task task) {
        if(task.isImportant()) {
            emailService.sendEmails(task);
            log.info("Task " + task.toString() + " was send to email-service");
        }
    }

}
