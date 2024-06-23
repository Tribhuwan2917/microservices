package com.pal.user_microservics.RatingServices.services.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class ApiResponse {
    private String message;
    private String status;
    private Integer errorCode;
}
