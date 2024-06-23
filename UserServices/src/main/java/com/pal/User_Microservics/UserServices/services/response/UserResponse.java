package com.pal.User_Microservics.UserServices.services.response;

import lombok.*;

import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
    private String userId;
    private String userName;
    private String userEmail;
    private String userAbout;
    private List<RatingResponse> ratingResponseList;
}
