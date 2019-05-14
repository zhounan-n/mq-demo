package com.example.rabbitmqdemo.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhoun on 2019-05-14
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "hi, fanout msg";
        System.out.println("Sender: " + context);
        this.amqpTemplate.convertAndSend("fanoutExchange", "", context);
    }

}
