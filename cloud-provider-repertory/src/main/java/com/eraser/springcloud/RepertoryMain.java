package com.eraser.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wudongjun E-mail:wudongjun43@163.com
 * @create 2020/10/30 16:22
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class RepertoryMain {
    public static void main(String[] args) {
        SpringApplication.run(RepertoryMain.class , args);
    }
}
