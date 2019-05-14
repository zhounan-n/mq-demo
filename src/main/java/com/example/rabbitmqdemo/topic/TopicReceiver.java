package com.example.rabbitmqdemo.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhoun on 2019-05-14
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver {


    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver 1:" + message);
    }


}
