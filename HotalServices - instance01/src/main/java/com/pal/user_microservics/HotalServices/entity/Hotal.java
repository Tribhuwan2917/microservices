package com.pal.user_microservics.HotalServices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Hotal {
    @Id
    private String hotalId;
    private String hotalName;
    private String hotalLocation;
    private String hotalAbout;
}
