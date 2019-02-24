package com.rabbit.publish.rabbitpublisher;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/message")
public class MessageController {

    MessageSender messageSender;

    public MessageController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody CustomMessage message){
        messageSender.sendMessage(message.getText());
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
