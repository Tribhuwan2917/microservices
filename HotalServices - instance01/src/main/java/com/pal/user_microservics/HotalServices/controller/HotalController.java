package com.pal.user_microservics.HotalServices.controller;

import com.pal.user_microservics.HotalServices.services.HotalServices;
import com.pal.user_microservics.HotalServices.services.request.HotalRequest;
import com.pal.user_microservics.HotalServices.services.response.HotalResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${HotalServices.base.URL}")
@Validated
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
    @GetMapping("${HotalServices.Get_By_Id.URL}")
    public ResponseEntity<HotalResponse> getHotalById(@PathVariable("hotalId") @Pattern(regexp = "H[0-9]{4}",message = "Invalid Hotal Id") String hotalId)
    {
//        System.out.println(hotalServices.getHotalById(hotalId));
        System.out.println("I am hotal Services instance 01");
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
