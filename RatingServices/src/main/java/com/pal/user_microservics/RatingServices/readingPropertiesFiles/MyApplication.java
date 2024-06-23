package com.pal.user_microservics.RatingServices.readingPropertiesFiles;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public class MyApplication {
//    @Value("Hi How are you")
    @Value("${MyApp.name}")
    private String appName;
}
