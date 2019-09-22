package com.taskservice.taskservice.api.service;

import com.taskservice.taskservice.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailService {

    @Autowired
    private RestTemplate template;

    @Value("${email.service.host}")
    private String emailServiceHost;

    @Value("${email.service.context-path}")
    private String emailServiceContextPath;

    @Value("${email.service.endpoint}")
    private String emailServiceEndpoint;

    @Value("${email.service.endpoint.send-emails}")
    private String emailServiceEndpointForSendEmails;

    public void sendEmails(Task task) {
        ResponseEntity<String> responseEntity = template.postForEntity(emailServiceHost
                + emailServiceContextPath
                + emailServiceEndpoint
                + emailServiceEndpointForSendEmails, task, String.class);
        System.out.println(responseEntity.toString());
    }

}


