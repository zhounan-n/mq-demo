package com.example.rabbitmqdemo.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhoun on 2019-05-14
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "i am message all";
        System.out.println("Sender:"+context);
        this.amqpTemplate.convertAndSend("topicExhange","topic.1",context);
    }

    public void send1(String message){
        String  context = "i am mesage 1";
        System.out.println("Sender:"+context);
        this.amqpTemplate.convertAndSend("topicExchange","topic.message",context);
    }

    public void send2(String message){
        String context = "i am message 2";
        System.out.println("Sender:"+context);
        this.amqpTemplate.convertAndSend("topicExchange","topic.messages",context);
    }

}
