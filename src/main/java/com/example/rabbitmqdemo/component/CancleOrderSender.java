package com.example.rabbitmqdemo.component;

import com.example.rabbitmqdemo.enums.QueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhoun on 2019-05-22
 */
@Component
public class CancleOrderSender {

    private static final Logger logger = LoggerFactory.getLogger(CancleOrderSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Long orderId, Long delayTimes) {
        //给延迟队列发消息
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange(), QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey(), orderId, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //设置延迟毫秒数
                message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                message.getMessageProperties().setDelay(3*60*1000);
                return message;
            }
        });
        logger.info("send orderId:{}",orderId);
    }
}
