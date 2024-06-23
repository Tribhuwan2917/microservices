package com.pal.User_Microservics.UserServices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    private String userId;
    private String userName;
    private String userEmail;
    private String userAbout;

}
