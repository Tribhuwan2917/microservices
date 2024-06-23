package com.pal.user_microservics.RatingServices.services.request;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class RatingRequest {
    @Pattern(regexp = "R[0-9]{4}",message = "Invalid RatingId")
    private String ratingId;
    @Pattern(regexp = "U[0-9]{4}",message = "Invalid UserId")
    private String userId;
    @Pattern(regexp = "H[0-9]{4}",message = "Invalid HotalId")
    private String hotalId;
    private String rating;
    private String feedback;
}
