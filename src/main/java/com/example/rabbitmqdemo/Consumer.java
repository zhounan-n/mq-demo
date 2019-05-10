package com.example.rabbitmqdemo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhoun on 2019-05-09
 */
@Component
@RabbitListener(queues = "okong")
public class Consumer {

    @RabbitHandler
    public void process(String message){

        System.out.println("接收的消息为："+message);
    }

}
