package org.spring.cloud.aws.sample.listener;

import org.spring.cloud.aws.sample.dtos.SimpleMessage;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener {

    @SqsListener("test-spring-cloud-aws-sdk")
    public void getMessage(SimpleMessage simpleMessage){
        System.out.println("id: "+simpleMessage.getId()+" - message: "+simpleMessage.getMessage());
    }
}
