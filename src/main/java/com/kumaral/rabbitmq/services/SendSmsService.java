package com.kumaral.rabbitmq.services;

import com.kumaral.rabbitmq.model.UserRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendSmsService {
    @RabbitListener(queues = "q.send-sms")
    public void sendSms(UserRegistrationRequest request) {
        log.info("Sending sms to {} ", request.getMobileNumber());
    }
}