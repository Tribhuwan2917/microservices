package com.pal.User_Microservics.UserServices.services.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HotalResponse {
    private String hotalId;
    private String hotalName;
    private String hotalLocation;
    private String hotalAbout;
}
