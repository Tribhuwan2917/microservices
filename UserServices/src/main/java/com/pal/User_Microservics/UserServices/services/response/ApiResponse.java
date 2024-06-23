package com.pal.User_Microservics.UserServices.services.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private String status;
    private Integer errorCode;
}
