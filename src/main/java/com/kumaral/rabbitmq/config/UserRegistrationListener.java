package com.kumaral.rabbitmq.config;

import com.kumaral.rabbitmq.model.UserRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserRegistrationListener {
    private final RabbitTemplate rabbitTemplate;

    public UserRegistrationListener(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = {"q.user-registration"}, containerFactory = "rabbitListenerContainerFactory")
    public void onUserRegistration(UserRegistrationRequest event)  {
        log.info("User Registration Event Received: {}", event);

//        executeRegistration(event);

        rabbitTemplate.convertAndSend("x.post-registration","", event);
    }

    private void executeRegistration(UserRegistrationRequest event) {
        log.info("Executing User Registration Event: {}", event);

        throw new RuntimeException("Registration Failed");

    }
}
