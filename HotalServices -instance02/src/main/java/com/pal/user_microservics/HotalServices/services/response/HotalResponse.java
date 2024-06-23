package com.pal.user_microservics.HotalServices.services.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter

public class HotalResponse{
    private String hotalId;
    private String hotalName;
    private String hotalLocation;
    private String hotalAbout;
}
