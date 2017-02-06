package org.spring.cloud.aws.sample.listener;

import org.spring.cloud.aws.sample.dtos.SimpleMessage;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy.ON_SUCCESS;

@Component
public class QueueListener {

    @SqsListener(value = "test-spring-cloud-aws-sdk", deletionPolicy = ON_SUCCESS)
    public void getMessage(SimpleMessage simpleMessage){
        System.out.println("id: "+simpleMessage.getId()+" - message: "+simpleMessage.getMessage());
    }
}
