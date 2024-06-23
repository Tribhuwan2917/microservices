package com.pal.user_microservics.RatingServices.repository;

import com.pal.user_microservics.RatingServices.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RatingRepository extends JpaRepository<Rating,String> {
    @Query("SELECT rating FROM Rating rating WHERE rating.userId=:userId")
    public List<Rating> getRatingByUserId(String userId);
}
