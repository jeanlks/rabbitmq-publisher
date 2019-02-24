package com.rabbit.publish.rabbitpublisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
    private final RabbitTemplate template;

    private static final Logger log = LoggerFactory.getLogger(MessageSender.class);

    public MessageSender(RabbitTemplate template) {
        this.template = template;
    }

    public void sendMessage(String messageStr) {
        final CustomMessage message = new CustomMessage(messageStr);
        String msg = "Messagem";
        log.info("Sending message to queue.");
        template.convertAndSend("test","test", message);
    }
}
