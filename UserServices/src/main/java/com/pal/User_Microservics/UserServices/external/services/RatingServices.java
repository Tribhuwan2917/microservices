package com.pal.User_Microservics.UserServices.external.services;

import com.pal.User_Microservics.UserServices.services.response.RatingResponse;
import jakarta.validation.constraints.Pattern;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATINGSERVICES")
//@FeignClient(name="xyz",url = "localhost:8083/")
//@FeignClient(name ="RATINGSERVICES",url = "",path = "contextPath")
public interface RatingServices {
    @GetMapping("${UserServices.GetRatingURL.feignURL}")
    public List<RatingResponse> getRatingResponseByUserid(@PathVariable("userId") @Pattern(regexp = "U[0-9]{4}",message = "Invalid UserId") String userId);

}
