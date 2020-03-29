package com.eraser.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wudongjun E-mail:wudongjun43@163.com
 * @create 2020/3/27 22:06
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate getRestTemlate(){
        return new RestTemplate();
    }
}
