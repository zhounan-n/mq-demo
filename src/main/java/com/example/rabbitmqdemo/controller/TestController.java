package com.example.rabbitmqdemo.controller;

import com.example.rabbitmqdemo.component.CancleOrderSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhoun on 2019-05-22
 */
@RestController
public class TestController {

    @Autowired
    private CancleOrderSender cancleOrderSender;

    @GetMapping(value = "/cancelOrder")
    @ResponseBody
    public String cancelOrder(Long orderId){
        Long delay = Long.valueOf(3*60*1000);
        cancleOrderSender.sendMessage(1L,delay);
        return "3分钟后取消";
    }
}
