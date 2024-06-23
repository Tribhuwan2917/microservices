package com.pal.user_microservics.HotalServices.services;

import com.pal.user_microservics.HotalServices.services.request.HotalRequest;
import com.pal.user_microservics.HotalServices.services.response.HotalResponse;

import java.util.List;

public interface HotalServices {
    public String createHotal(HotalRequest hotalRequest);
    public HotalResponse getHotalById(String hotalId);
    public List<HotalResponse> getAllHotal();
    public String deleteHotal(String hotalId);
    public String updateHotal(HotalRequest hotalRequest);
}
