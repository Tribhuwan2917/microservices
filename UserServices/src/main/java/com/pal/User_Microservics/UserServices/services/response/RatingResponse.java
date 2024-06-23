package com.pal.User_Microservics.UserServices.services.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RatingResponse {
    private String ratingId;
    private String userId;
    private String hotalId;
    private String rating;
    private String feedback;
    private HotalResponse hotalResponse;
}
