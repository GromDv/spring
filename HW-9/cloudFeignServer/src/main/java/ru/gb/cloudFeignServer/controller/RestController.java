package ru.gb.cloudFeignServer.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    DiscoveryClient client;

    @RequestMapping("/fs")
    public String hello() {
        List<ServiceInstance> instances = client.getInstances("HelloFeignServer");
        ServiceInstance selectedInstance = instances
                .get(new Random().nextInt(instances.size()));
        return "Hello World: " + selectedInstance.getServiceId() + ":" + selectedInstance
                .getHost() + ":" + selectedInstance.getPort();
    }
}
