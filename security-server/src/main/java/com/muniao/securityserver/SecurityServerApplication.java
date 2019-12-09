package com.muniao.securityserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableCaching
@MapperScan("com.muniao.securityserver.mapper")
@EnableEurekaClient
public class SecurityServerApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SecurityServerApplication.class, args);
    }

}
