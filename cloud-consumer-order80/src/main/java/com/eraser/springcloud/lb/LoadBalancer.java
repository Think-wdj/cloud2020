package com.eraser.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Eraser E-mail:wudongjun43@163.com
 * @create 2020/11/1 22:46
 */
public interface LoadBalancer {

    /**
     * get instance from instances list
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
