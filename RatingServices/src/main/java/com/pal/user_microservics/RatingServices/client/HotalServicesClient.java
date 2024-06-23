package com.pal.user_microservics.RatingServices.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HotalServices",path = "/user-services/v1/Hotals/")
public interface HotalServicesClient {
    @GetMapping("getHotal/{hotalId}")
    public HotalResponse getHotalById(@PathVariable("hotalId") String hotalId);
}
