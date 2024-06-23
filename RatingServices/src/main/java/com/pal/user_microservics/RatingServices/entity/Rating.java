package com.pal.user_microservics.RatingServices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hotalId;
    private String rating;
    private String feedback;

}

