package org.spring.cloud.aws.sample.controllers;

import org.spring.cloud.aws.sample.dtos.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class QueueController {

    private static final String DEFAULT_QUEUE_NAME = "test-spring-cloud-aws-sdk";

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @RequestMapping(
            path = "/sqs/message",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity addMessage(@RequestBody @Valid SimpleMessage simpleMessage){
        simpleMessage.setId(UUID.randomUUID().toString());
        this.queueMessagingTemplate.convertAndSend(DEFAULT_QUEUE_NAME, simpleMessage);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
