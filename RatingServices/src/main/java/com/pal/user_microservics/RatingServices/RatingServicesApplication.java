package com.pal.user_microservics.RatingServices;

import com.pal.user_microservics.RatingServices.readingPropertiesFiles.MyApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients
//@PropertySource("myprops/MyProperties.properties")
@PropertySource("classpath:myprops/MyProperties.properties")
public class RatingServicesApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext=SpringApplication.run(RatingServicesApplication.class, args);
//		RatingRepository ratingRepository=configurableApplicationContext.getBean(RatingRepository.class);
//		System.out.println(ratingRepository.getRatingByUserId("U0001"));
//		HotalServicesClient hotalServicesClient=configurableApplicationContext.getBean(HotalServicesClient.class);
//		for(int i=1;i<=10;i++)
//		{
//			HotalResponse hotalResponse=hotalServicesClient.getHotalById("H0001");
//			System.out.println(hotalResponse);
//		}
		MyApplication myApplication=configurableApplicationContext.getBean(MyApplication.class);
		System.out.println(myApplication);
	}

}
