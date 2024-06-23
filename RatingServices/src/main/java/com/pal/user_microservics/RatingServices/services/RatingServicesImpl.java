package com.pal.user_microservics.RatingServices.services;

import com.pal.user_microservics.RatingServices.constant.HttpResponseMessage;
import com.pal.user_microservics.RatingServices.constant.RatingExceptionMessage;
import com.pal.user_microservics.RatingServices.entity.Rating;
import com.pal.user_microservics.RatingServices.exception.RatingAlreadyExistsException;
import com.pal.user_microservics.RatingServices.exception.RatingNotFoundException;
import com.pal.user_microservics.RatingServices.repository.RatingRepository;
import com.pal.user_microservics.RatingServices.services.request.RatingRequest;
import com.pal.user_microservics.RatingServices.services.response.RatingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RatingServicesImpl implements RatingServices{
    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public String addRating(RatingRequest ratingRequest) {
        if(ratingRepository.existsById(ratingRequest.getRatingId()))
        {
            throw new RatingAlreadyExistsException(RatingExceptionMessage.RATING_ALREADY_EXISTS);
        }else {
            Rating rating=Rating.builder().ratingId(ratingRequest.getRatingId()).feedback(ratingRequest.getFeedback()).hotalId(ratingRequest.getHotalId()).userId(ratingRequest.getUserId()).rating(ratingRequest.getRating()).build();
            ratingRepository.save(rating);
        }
        return HttpResponseMessage.RATING_CREATED+ratingRequest.getRatingId();
    }

    @Override
    public String updateRating(RatingRequest ratingRequest) {
        if(ratingRepository.existsById(ratingRequest.getRatingId()))
        {
            Rating rating=Rating.builder().ratingId(ratingRequest.getRatingId()).feedback(ratingRequest.getFeedback()).hotalId(ratingRequest.getHotalId()).userId(ratingRequest.getUserId()).rating(ratingRequest.getRating()).build();
            ratingRepository.save(rating);
            return HttpResponseMessage.RATING_UPDATE_BY_ID+ratingRequest.getRatingId();
        }
       throw new RatingNotFoundException(RatingExceptionMessage.RATING_NOT_FOUND);
    }

    @Override
    public List<RatingResponse> getAllRating() {
        List<Rating> ratingList=ratingRepository.findAll();
        if(ratingList.isEmpty())
        {
            throw new RatingNotFoundException(RatingExceptionMessage.RATING_EMPTY_LIST);
        }else {
            List<RatingResponse> ratingResponseList = new ArrayList<>();
            for (Rating rating : ratingList) {
                RatingResponse ratingResponse = RatingResponse.builder().feedback(rating.getFeedback()).rating(rating.getRating()).hotalId(rating.getHotalId()).userId(rating.getUserId()).ratingId(rating.getRatingId()).build();
                ratingResponseList.add(ratingResponse);
            }
            return ratingResponseList;
        }
    }

    @Override
    public RatingResponse getRatingById(String ratingId) {
        if(ratingRepository.existsById(ratingId))
        {
            Rating rating=ratingRepository.findById(ratingId).get();
            RatingResponse ratingResponse = RatingResponse.builder().feedback(rating.getFeedback()).rating(rating.getRating()).hotalId(rating.getHotalId()).userId(rating.getUserId()).ratingId(rating.getRatingId()).build();
            return ratingResponse;
        }else {
            throw new RatingNotFoundException(RatingExceptionMessage.RATING_NOT_FOUND);
        }
    }

    @Override
    public String deleteRating(String ratingId) {

        if(ratingRepository.existsById(ratingId))
        {
            ratingRepository.deleteById(ratingId);
            return HttpResponseMessage.RATING_DELETED_BY_ID+ratingId;
        }else {
            throw new RatingNotFoundException(RatingExceptionMessage.RATING_NOT_FOUND);
        }
    }

    @Override
    public List<RatingResponse> getRatingByUserId(String userId) {
        List<Rating> ratingList=ratingRepository.getRatingByUserId(userId);
        List<RatingResponse> ratingResponseList=new ArrayList<>();
        for(Rating rating:ratingList)
        {
            RatingResponse ratingResponse=RatingResponse.builder().userId(rating.getUserId()).hotalId(rating.getHotalId()).ratingId(rating.getRatingId()).rating(rating.getRating()).feedback(rating.getFeedback()).build();
            //ratingServices.getHotalById=http://localhost:8082/hotal-services/v1/Gethotal/
            ratingResponseList.add(ratingResponse);
        }
        return ratingResponseList;
    }
}
