package com.pal.User_Microservics.UserServices.services;

import com.netflix.discovery.converters.Auto;
import com.pal.User_Microservics.UserServices.constant.UserExceptionMessage;
import com.pal.User_Microservics.UserServices.constant.UserHttpRequestMessage;
import com.pal.User_Microservics.UserServices.entity.User;
import com.pal.User_Microservics.UserServices.exceptions.UserNotFoundException;
import com.pal.User_Microservics.UserServices.external.services.HotalService;
import com.pal.User_Microservics.UserServices.external.services.RatingServices;
import com.pal.User_Microservics.UserServices.respository.UserRepository;
import com.pal.User_Microservics.UserServices.services.request.UserRequest;
import com.pal.User_Microservics.UserServices.services.response.HotalResponse;
import com.pal.User_Microservics.UserServices.services.response.RatingResponse;
import com.pal.User_Microservics.UserServices.services.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotalService hotalService;
    @Autowired
    private RatingServices ratingServices;
    @Value("${UserServices.GetRatingURL}")
    private String getRatingByUserIdUrl;
    @Value("${UserServices.GetHotalByHotalId}")
    private String getHotalByHotalIdUrl;
    @Override
    public String createUser(UserRequest userRequest) {
     if(userRepository.existsById(userRequest.getUserId()))
     {
         throw new UserNotFoundException(UserExceptionMessage.USER_ALREADY_EXISTS+userRequest.getUserId());
     }else {
         User user=User.builder().userId(userRequest.getUserId()).userName(userRequest.getUserName()).userAbout(userRequest.getUserAbout()).userEmail(userRequest.getUserEmail()).build();
         userRepository.save(user);


     }
        return UserHttpRequestMessage.USER_CREATD+userRequest.getUserId();
    }

    @Override
    public UserResponse getUserById(String userId) {
        if(userRepository.existsById(userId))
        {
            User user=userRepository.findById(userId).get();
            UserResponse userResponse=UserResponse.builder().userId(user.getUserId()).userName(user.getUserName()).userEmail(user.getUserEmail()).userAbout(user.getUserAbout()).build();
            List<RatingResponse> ratingResponseList;
//           ratingResponseList= Arrays.stream(restTemplate.getForObject(getRatingByUserIdUrl+userId,RatingResponse[].class)).toList();
            ratingResponseList=ratingServices.getRatingResponseByUserid(userId);
           ratingResponseList.forEach(ratingResponse -> {
//               HotalResponse hotalResponse=restTemplate.getForObject(getHotalByHotalIdUrl+ratingResponse.getHotalId(),HotalResponse.class);
               HotalResponse hotalResponse=hotalService.getHotalResponse(ratingResponse.getHotalId());
              // System.out.println(hotalResponse);
               ratingResponse.setHotalResponse(hotalResponse);
           });
           userResponse.setRatingResponseList(ratingResponseList);
            return userResponse;
        }else{
            throw new UserNotFoundException(UserExceptionMessage.USER_NOT_FOUND);

        }

    }

    @Override
    public List<UserResponse> getAllUser() {
        List<UserResponse> userResponseList=new ArrayList<>();
        List<User> userList=userRepository.findAll();
        if(!userList.isEmpty()) {
            for (User user : userList) {
                UserResponse userResponse = UserResponse.builder().userId(user.getUserId()).userName(user.getUserName()).userEmail(user.getUserEmail()).userAbout(user.getUserAbout()).build();

                // There the problem is that , we are hard coding url(port and ip address ) which is not good
                // Solution of this problem is that , we use name of the service if that services has register in services registry.
               List<RatingResponse> ratingResponseList=ratingServices.getRatingResponseByUserid(user.getUserId() );
                       //List<RatingResponse> ratingResponseList=Arrays.stream(restTemplate.getForObject(getRatingByUserIdUrl+user.getUserId(),RatingResponse[].class)).toList();
               ratingResponseList.stream().forEach(ratingResponse -> {
//                    HotalResponse hotalResponse=restTemplate.getForEntity(getHotalByHotalIdUrl+ratingResponse.getHotalId(), HotalResponse.class).getBody();
                   HotalResponse hotalResponse=hotalService.getHotalResponse(ratingResponse.getHotalId());
                    ratingResponse.setHotalResponse(hotalResponse);
                });
                userResponse.setRatingResponseList(ratingResponseList);
                userResponseList.add(userResponse);
            }
            return userResponseList;
        }else {
            throw new UserNotFoundException(UserExceptionMessage.USER_EMPTY_LIST);
        }
    }

    @Override
    public String updateUser(UserRequest userRequest) {
        if(userRepository.existsById(userRequest.getUserId()))
        {
            User user=User.builder().userId(userRequest.getUserId()).userName(userRequest.getUserName()).userEmail(userRequest.getUserEmail()).userAbout(userRequest.getUserAbout()).build();
            userRepository.save(user);
        }else {
            throw new UserNotFoundException(UserExceptionMessage.USER_NOT_FOUND+userRequest.getUserId());
        }
        return UserHttpRequestMessage.USER_UPDATE_BY_ID+userRequest.getUserId();
    }

    @Override
    public String deleteUser(String userId) {

        if(userRepository.existsById(userId))
        {
            userRepository.deleteById(userId);
        }else {
            throw new UserNotFoundException(UserExceptionMessage.USER_NOT_FOUND+userId);
        }
        return UserHttpRequestMessage.USER_DELETED_BY_ID+userId;
    }
}
