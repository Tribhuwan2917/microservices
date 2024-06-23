package com.pal.user_microservics.RatingServices.services;

import com.pal.user_microservics.RatingServices.services.request.RatingRequest;
import com.pal.user_microservics.RatingServices.services.response.RatingResponse;

import java.util.List;

public interface RatingServices {
    public String addRating(RatingRequest ratingRequest);
    public String updateRating(RatingRequest ratingRequest);
    public List<RatingResponse> getAllRating();
    public RatingResponse getRatingById(String ratingId);
    public String deleteRating(String ratingId);
    public List<RatingResponse> getRatingByUserId(String userId);
}
