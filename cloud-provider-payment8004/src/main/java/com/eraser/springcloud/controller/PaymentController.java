package com.eraser.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wudongjun E-mail:wudongjun43@163.com
 * @create 2020/4/9 21:47
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zk")
    public String paymentzk() {
        return "springcloud with zookeeper : " + serverPort + "\t" + IdUtil.simpleUUID();
    }
}
