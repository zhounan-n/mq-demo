package com.example.rabbitmqdemo.component;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhoun on 2019-05-22
 */
@Component
@RabbitListener(queues = "mall.order.cancel.ttl")
public class CancleOrderReceiver {

    private static final Logger logger = LoggerFactory.getLogger(CancleOrderReceiver.class);


    @Autowired
    private AmqpTemplate amqpTemplate;

    @RabbitHandler
    public void handle(Long orderId) {

        //业务处理
        logger.info("process order:{}", orderId);
    }

}
