package com.pal.user_microservics.RatingServices.services.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class RatingResponse {
    private String ratingId;
    private String userId;
    private String hotalId;
    private String rating;
    private String feedback;

}
