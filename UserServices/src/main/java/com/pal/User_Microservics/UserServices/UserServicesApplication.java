package com.pal.User_Microservics.UserServices;

import com.pal.User_Microservics.UserServices.external.services.HotalRequest;
import com.pal.User_Microservics.UserServices.external.services.HotalService;
import com.pal.User_Microservics.UserServices.services.response.HotalResponse;
import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@RefreshScope
public class UserServicesApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext=SpringApplication.run(UserServicesApplication.class, args);
		HotalService hotalService=configurableApplicationContext.getBean(HotalService.class);
		//HotalRequest hotalRequest=HotalRequest.builder().hotalAbout("Feign hotal About").hotalId("H0010").hotalLocation("Jaunpur Uttarpradesh").hotalName("Maharaja").build();
//		String response=hotalService.postHotal(hotalRequest);
//		String response=hotalService.updateHotal(hotalRequest);
//		String response=hotalService.deleteHotal("H0010");
//		System.out.println(response);
//		RestTemplate restTemplate1=configurableApplicationContext.getBean(RestTemplate.class);
//		for(int i=1;i<=10;i++){
//	HotalResponse hotalResponse=restTemplate1.getForObject("http://HOTALSERVICES/user-services/v1/Hotals/getHotal/H0001", HotalResponse.class);
//	System.out.println(hotalResponse);
//	}
		//++++++++++++++How get instance and service name , which is register in services discovery
//		DiscoveryClient discoveryClient=configurableApplicationContext.getBean(DiscoveryClient.class);  By using discovery client we are not able to get loadbalancer features , because we are always accessing .get(index)
//		List<ServiceInstance> serviceInstanceList=discoveryClient.getInstances("HOTALSERVICES");
//		List<String>serviceList= discoveryClient.getServices();
//		System.out.println("This is all services register with discovery service"+serviceList);
//		System.out.println(discoveryClient.getInstances("HOTALSERVICES").get(0).isSecure());
//		System.out.println(discoveryClient.getInstances("HOTALSERVICES").get(0).getUri());
		//=====================================================================================Managing load balancer====================================
		LoadBalancerClient loadBalancerClient=configurableApplicationContext.getBean(LoadBalancerClient.class);
//		for(int i=1;i<=2;i++) {
//			ServiceInstance serviceInstance1 = loadBalancerClient.choose("HOTALSERVICES");
//			System.out.println(serviceInstance1.getInstanceId() + " Of Service " + serviceInstance1.getServiceId());
//		}
		// how to access metadata from of registry map(Which every services mentain )
//		ServiceInstance serviceInstance=loadBalancerClient.choose("RATINGSERVICES");
//		System.out.println(serviceInstance.getMetadata());




	}

}
