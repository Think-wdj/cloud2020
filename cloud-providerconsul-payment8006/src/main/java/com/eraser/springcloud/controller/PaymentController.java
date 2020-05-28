package com.eraser.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wudongjun E-mail:wudongjun43@163.com
 * @create 2020/4/12 10:43
 */
@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consul")
    public String paymentConsul() {
        return "springcloud with consul : " + serverPort + "\t" + IdUtil.simpleUUID();
    }
}
