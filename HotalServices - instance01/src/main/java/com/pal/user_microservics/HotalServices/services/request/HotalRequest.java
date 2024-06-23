package com.pal.user_microservics.HotalServices.services.request;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class HotalRequest {
    @Pattern(regexp = "H[0-9]{4}",message = "Invalid Hotal Id")
    private String hotalId;
    private String hotalName;
    private String hotalLocation;
    private String hotalAbout;
}
