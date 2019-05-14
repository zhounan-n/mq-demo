package com.example.rabbitmqdemo.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhoun on 2019-05-14
 */
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiver2 {


    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver B" + message);
    }

}
