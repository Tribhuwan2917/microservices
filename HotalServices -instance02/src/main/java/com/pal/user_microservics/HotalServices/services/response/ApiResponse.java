package com.pal.user_microservics.HotalServices.services.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ApiResponse {
    private String message;
    private String status;
    private Integer errorCode;

}
