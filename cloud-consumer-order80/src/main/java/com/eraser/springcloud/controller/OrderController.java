package com.eraser.springcloud.controller;

import com.eraser.springcloud.entities.CommonResult;
import com.eraser.springcloud.entities.Payment;
import com.eraser.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author wudongjun E-mail:wudongjun43@163.com
 * @create 2020/3/26 22:34
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public  CommonResult<Payment> getPayment(@PathVariable("id") Long id ){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/payment/getForEntity/{id}")
    public  CommonResult<Payment> getPayment2(@PathVariable("id") Long id ){
        final ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getStatusCode()+"\t---"+entity.getHeaders()+"\t---"+entity.getBody());
            return entity.getBody();
        }else{
            return  new CommonResult<Payment>(406,"操作失败");
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances==null||instances.size()<=0){
            return null;
        }
        final ServiceInstance serviceInstance = loadBalancer.instances(instances);
        final URI uri = serviceInstance.getUri();
        return  this.restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
