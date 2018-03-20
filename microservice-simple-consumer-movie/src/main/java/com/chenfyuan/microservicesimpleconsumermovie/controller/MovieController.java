package com.chenfyuan.microservicesimpleconsumermovie.controller;


import com.chenfyuan.microservicesimpleconsumermovie.bo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    static Logger log= LoggerFactory.getLogger(MovieController.class);
    @Value("${userService.url}")
    private  String url;
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){

        User findOne=restTemplate.getForObject(url +id,User.class);
        return findOne;

    }
    @GetMapping("/loguser")
    public void logUserInstance(){
        ServiceInstance serviceInstance=this.loadBalancerClient.choose("microservice-provider-user");
      log.info(serviceInstance.getHost()+","+serviceInstance.getServiceId()+","+serviceInstance.getPort());
    }
}
