package com.taskservice.taskservice;

import com.taskservice.taskservice.model.Email;
import com.taskservice.taskservice.model.Task;
import com.taskservice.taskservice.respository.EmailRepository;
import com.taskservice.taskservice.respository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TaskServiceApplication {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private TaskRepository taskRepository;

//
//    @Bean
//    CommandLineRunner preLoadMongo() {
//        return args -> {
//            emailRepository.save(new Email("aaaa@aaaa.com"));
//            emailRepository.save(new Email("bbbbb@bbbbb.pl"));
//            emailRepository.save(new Email("ccccc@cccc.com"));
//        };
//    }

    //
//    @Bean
//    CommandLineRunner preLoadMongo() {
//        List<Email> emails = new ArrayList<>(){{add(emailRepository.findByEmail("aaaa@aaaa.com").get());}};
//        List<Email> emails2 = new ArrayList<>(){{add(emailRepository.findByEmail("aaaa@aaaa.com").get()); add(emailRepository.findByEmail("bbbbb@bbbbb.pl").get());}};
//        List<Email> emails3 = new ArrayList<>(){{add(emailRepository.findByEmail("ccccc@cccc.com").get());}};
//        return args -> {
//            taskRepository.save(new Task("A123", "SUPER TASK", false, emails));
//            taskRepository.save(new Task("B123", "NOT SUPER TASK", true, emails2 ));
//            taskRepository.save(new Task("C123", "BEST TASK", true, emails3 ));
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(TaskServiceApplication.class, args);
    }

}
