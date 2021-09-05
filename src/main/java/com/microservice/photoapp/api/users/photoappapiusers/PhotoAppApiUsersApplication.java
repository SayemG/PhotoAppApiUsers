package com.microservice.photoapp.api.users.photoappapiusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan({"com.microservice.photoapp.api.users.ui.controllers"})
public class PhotoAppApiUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoAppApiUsersApplication.class, args);
    }

}
