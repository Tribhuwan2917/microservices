package com.pal.user_microservics.HotalServices.controller;

import com.pal.user_microservics.HotalServices.services.HotalServices;
import com.pal.user_microservics.HotalServices.services.request.HotalRequest;
import com.pal.user_microservics.HotalServices.services.response.HotalResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${HotalServices.base.URL}")
@Validated
@Slf4j
public class HotalController {
    /*HotalServices.base.URL=hotal-services/v1/
HotalServices.Get_By_Id.URL=Gethotal/{hotalId}
HotalServices.base.URL=hotal-services/v1/
HotalServices.Get_By_Id.URL=Gethotal/{hotalId}
HotalServices.Get_All_Hotals=GetAllhotal
HotalServices.CreateHotal=CreateHotal
HotalServices.UpdateHotal=UpdateHotal
HotalServices.DeleteHotal=DeleteHotal/{hotalId}*/
    @Autowired
    private HotalServices hotalServices;
//    private Logger logger;
    //private static final Logger logger= LoggerFactory.getLogger(HotalServices.class); Output:- 2024-06-23T22:52:01.830+05:30  INFO 22432 --- [HotalServices] [nio-8082-exec-2] c.p.u.H.services.HotalServices           : This is logging information
//    private static final Logger logger=LoggerFactory.getLogger(HotalController.class); Output:- 2024-06-23T22:56:35.658+05:30  INFO 19936 --- [HotalServices] [nio-8082-exec-1] c.p.u.H.controller.HotalController       : This is logging information
//private static final Logger logger=LoggerFactory.getLogger(HotalController.class);
    @GetMapping("${HotalServices.Get_By_Id.URL}")
    public ResponseEntity<HotalResponse> getHotalById(@PathVariable("hotalId") @Pattern(regexp = "H[0-9]{4}",message = "Invalid Hotal Id") String hotalId)
    {
//        System.out.println(hotalServices.getHotalById(hotalId));
        System.out.println("I am hotal Services instance 01");
        log.info("This is logging information");
//        log.debug("I am Debugs , how are you");
        //logger.error("This Error Occur For {}","Nothings",new RuntimeException("Just For Testing"));
        return new ResponseEntity<>(hotalServices.getHotalById(hotalId), HttpStatus.OK);
    }
    @GetMapping("${HotalServices.Get_All_Hotals}")
    public ResponseEntity<List<HotalResponse>> getAllHotals()
    {
        return new ResponseEntity<>(hotalServices.getAllHotal(),HttpStatus.OK);
    }
    @PostMapping("${HotalServices.CreateHotal}")
    public ResponseEntity<String> createHotal(@RequestBody @Valid HotalRequest hotalRequest)
    {
        return new ResponseEntity<>(hotalServices.createHotal(hotalRequest),HttpStatus.CREATED);
    }
    @PutMapping("${HotalServices.UpdateHotal}")
    public ResponseEntity<String> updateHotal(@RequestBody @Valid HotalRequest hotalRequest)
    {
        return new ResponseEntity<>(hotalServices.updateHotal(hotalRequest),HttpStatus.CREATED);
    }
    @DeleteMapping("${HotalServices.DeleteHotal}")
    public ResponseEntity<String> deleteHotal(@PathVariable("hotalId") @Pattern(regexp = "H[0-9]{4}",message = "Invalid HotalId") String hotalId)
    {
        return new ResponseEntity<>(hotalServices.deleteHotal(hotalId),HttpStatus.OK);
    }

}
