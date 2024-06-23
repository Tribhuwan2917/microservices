package com.pal.User_Microservics.UserServices.services;

import com.pal.User_Microservics.UserServices.services.request.UserRequest;
import com.pal.User_Microservics.UserServices.services.response.UserResponse;

import java.util.List;

public interface UserServices {
    public String createUser(UserRequest userRequest);
    public UserResponse getUserById(String userId);
    public List<UserResponse> getAllUser();
    public String updateUser(UserRequest userRequest);
    public String deleteUser(String userId);
}
