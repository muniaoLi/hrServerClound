package com.muniao.zuulgateway;

import com.muniao.zuulgateway.filter.LogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
@EnableCaching
@EnableEurekaClient
public class ZuulGatewayApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }

    @Bean
    public LogFilter logFilter()
    {
      return new LogFilter();
    }

}
