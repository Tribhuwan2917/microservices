package com.pal.user_microservics.RatingServices.client;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class HotalResponse{
    private String hotalId;
    private String hotalName;
    private String hotalLocation;
    private String hotalAbout;
}
