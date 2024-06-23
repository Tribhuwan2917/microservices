package com.pal.User_Microservics.UserServices.services.request;

import jakarta.validation.constraints.Pattern;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserRequest {
    @Pattern(regexp = "U[0-9]{4}",message = "Invalid UserId")
    private String userId;
    private String userName;
    private String userEmail;
    private String userAbout;
}
