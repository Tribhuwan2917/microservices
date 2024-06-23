package com.pal.user_microservics.RatingServices.controller;

import com.pal.user_microservics.RatingServices.services.RatingServices;
import com.pal.user_microservics.RatingServices.services.request.RatingRequest;
import com.pal.user_microservics.RatingServices.services.response.RatingResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${ratingServices.base.URL}")
@Validated
public class RatingController {
    /*ratingServices.base.URL=user-services/v1/
ratingServices.getRatingById.URL=getRatingById/{ratingId}
ratingServices.getAllRating=getAllRating
ratingServices.createRating=createRating
ratingServices.updateRating=updateRating
ratingServices.deleteRating=deleteRating/{ratingId}*/
    @Autowired
    private RatingServices ratingServices;
    @PostMapping("${ratingServices.createRating}")
    public ResponseEntity<String> addRating(@RequestBody @Valid RatingRequest ratingRequest)
    {
       return new ResponseEntity<>(ratingServices.addRating(ratingRequest), HttpStatus.CREATED);
    }
    @PutMapping("${ratingServices.updateRating}")
    public ResponseEntity<String> updateRating(@RequestBody @Valid RatingRequest ratingRequest)
    {
        return new ResponseEntity<>(ratingServices.updateRating(ratingRequest),HttpStatus.CREATED);
    }
    @GetMapping("${ratingServices.getRatingById.URL}")
    public ResponseEntity<RatingResponse> getRatingById(@PathVariable("ratingId") @Pattern(regexp = "R[0-9]{4}",message = "Invalid Rating Id") String ratingId)
    {
        System.out.println("This is something new");
        return new ResponseEntity<>(ratingServices.getRatingById(ratingId),HttpStatus.OK);
    }
    @GetMapping("${ratingServices.getAllRating}")
    public ResponseEntity<List<RatingResponse>> getAllRating()
    {
        return new ResponseEntity<>(ratingServices.getAllRating(),HttpStatus.OK);
    }
    //ratingServices.getRatingByUserId=getRatingByUserid/{userId}
    @GetMapping("${ratingServices.getRatingByUserId}")
    public ResponseEntity<List<RatingResponse>> getRatingByUserId(@PathVariable("userId") @Pattern(regexp = "U[0-9]{4}",message = "Invalid UserId") String userId)
    {
     return new ResponseEntity<>(ratingServices.getRatingByUserId(userId),HttpStatus.OK);
    }
    @DeleteMapping("${ratingServices.deleteRating}")
    public ResponseEntity<String> deleteRatingById(@PathVariable("ratingId") @Pattern(regexp = "R[0-9]{4}",message = "Invalid Rating Id") String ratingId){
        return new ResponseEntity<>(ratingServices.deleteRating(ratingId),HttpStatus.OK);
    }
}
