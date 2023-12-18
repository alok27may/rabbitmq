package com.kumaral.rabbitmq.services;

import com.kumaral.rabbitmq.model.UserRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendEmailService {

    @RabbitListener(queues = "q.send-email")
    public void sendEmail(UserRegistrationRequest request) {
        log.info("Sending email to {}", request.getEmail());
    }
}