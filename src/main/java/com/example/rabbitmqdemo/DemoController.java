package com.example.rabbitmqdemo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhoun on 2019-05-09
 */
@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    @GetMapping("/send")
    public String sayHello(String msg){

        rabbitmqTemplate.convertAndSend("okong",msg);
        return "消息:{}"+msg+"已发送";
    }

}
