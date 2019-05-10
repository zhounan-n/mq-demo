package com.example.rabbitmqdemo;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhoun on 2019-05-09
 */
@Configuration
public class RabbitmqConfig {


    @Bean
    public Queue okongQueue() {
        return new Queue("okong");
    }


}
