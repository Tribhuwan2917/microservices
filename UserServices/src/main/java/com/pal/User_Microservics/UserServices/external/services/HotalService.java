package com.pal.User_Microservics.UserServices.external.services;

import com.pal.User_Microservics.UserServices.services.response.HotalResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "HOTALSERVICES")
@Validated
public interface HotalService {
    @GetMapping("${UserServices.GetHotalByHotalId.feignURL}")
    public HotalResponse getHotalResponse(@PathVariable("hotalId") String hotalId);
    @PostMapping("${UserServices.PostHotal.feignURL}")
    public String postHotal(@RequestBody @Valid HotalRequest hotalRequest);
    /*UserServices.UpdateHotal.feignURL:/hotal-services/v1/updatetHotal
UserServices.DeleteHotal.feignURL:/hotal-services/v1/deleteHotal/{hotalId}*/
    @PutMapping("${UserServices.UpdateHotal.feignURL}")
    public String updateHotal(@RequestBody @Valid HotalRequest hotalRequest);
    @DeleteMapping("${UserServices.DeleteHotal.feignURL}")
    public String deleteHotal(@PathVariable("hotalId") String hotalId);


}
