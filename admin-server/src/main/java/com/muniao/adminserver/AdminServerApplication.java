package com.muniao.adminserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminServerApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(AdminServerApplication.class, args);
    }

}
