package com.muniao.userserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserServerApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(UserServerApplication.class, args);
    }

}
