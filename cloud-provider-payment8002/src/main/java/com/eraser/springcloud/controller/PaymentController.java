package com.eraser.springcloud.controller;

import com.eraser.springcloud.entities.CommonResult;
import com.eraser.springcloud.entities.Payment;
import com.eraser.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wudongjun E-mail:wudongjun43@163.com
 * @create 2020/3/26 21:19
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){
        int  result = paymentService.create(payment);
        log.info("*****插入成功"+result);
        if (result > 0 ){
            return new CommonResult(200,"插入数据成功,serverPort"+serverPort,result);
        }else{
            return new CommonResult(406,"插入数据失败,serverPort"+serverPort);
        }
    }

    @GetMapping(value = "/get/{id}")
    public  CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****ABC查询结果"+payment);
        if (payment!=null ){
            return new CommonResult(200,"查询成功,serverPort"+serverPort,payment);
        }else{
            return new CommonResult(406,"没有对应记录,ID="+id+",serverPort"+serverPort);
        }
    }
}
