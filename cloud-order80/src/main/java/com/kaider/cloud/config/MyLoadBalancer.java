package com.kaider.cloud.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
