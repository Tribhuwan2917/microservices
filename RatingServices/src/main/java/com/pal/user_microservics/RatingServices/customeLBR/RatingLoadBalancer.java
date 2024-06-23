package com.pal.user_microservics.RatingServices.customeLBR;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(value = "HotalServices"
//        ,configuration = MyLoadBalancerConfiguration.class For Custome load Balancer
)
public class RatingLoadBalancer {
    @Bean
    @LoadBalanced
    public Feign.Builder feignBuilder()
    {
        return Feign.builder();
    }
}
