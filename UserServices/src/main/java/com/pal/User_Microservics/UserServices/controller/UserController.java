package com.pal.User_Microservics.UserServices.controller;

import com.pal.User_Microservics.UserServices.services.UserServices;
import com.pal.User_Microservics.UserServices.services.request.UserRequest;
import com.pal.User_Microservics.UserServices.services.response.UserResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Payload;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("${UserServices.base.URL}")
@RestController
@Validated
public class UserController {
    @Autowired
    private UserServices userServices;
    //int count=1;
    //UserServices.Get_By_Id=
   @GetMapping("getByUserId/{userId}")
   //@CircuitBreaker(name = "ratingHotalBreaker",fallbackMethod = "ratingHotralFallbackMethod")
  // @Retry(name="ratingHotalRetry",fallbackMethod = "ratingHotalFallbackMethod")
   //@RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotalFallBackMethod")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("userId") @Pattern(regexp = "U[0-9]{4}",message = "Invalid UserId") String userId){
      // System.out.println("No Of Retry=:"+count++);
        return new ResponseEntity<>(userServices.getUserById(userId), HttpStatus.OK);
    }
    public ResponseEntity<UserResponse> ratingHotalFallBackMethod(String userId ,Exception exception)
    {
        System.out.println("Fallback has callled for RateLimiter");
//        System.out.println("Finally we got that, Services is , not in position to respond it");
//        System.out.println("Some Services are Down"+exception.getMessage());
        UserResponse userResponse=UserResponse.builder().userAbout("Services Down About").userEmail("Services down Emal").userName("Services Down user Name").userId("U7777").ratingResponseList(null).build();
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }
    @GetMapping("${UserServices.Get_All_Users}")
    public ResponseEntity<List<UserResponse>> getAllUsers()
    {
        return new ResponseEntity<>(userServices.getAllUser(),HttpStatus.OK);
    }
    @PostMapping("${UserServices.CreateUser}")
    public ResponseEntity<String> createUser(@RequestBody @Valid UserRequest userRequest)
    {
        return new ResponseEntity<>(userServices.createUser(userRequest),HttpStatus.CREATED);
    }

    @PutMapping("${UserServices.UpdateUser}")
    public ResponseEntity<String> updateUser(@RequestBody UserRequest userRequest)
    {
        return new ResponseEntity<>(userServices.updateUser(userRequest),HttpStatus.CREATED);
    }
    @DeleteMapping("${UserServices.DeleteUser}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") String userId)
    {
        return new ResponseEntity<>(userServices.deleteUser(userId),HttpStatus.OK);
    }

}
