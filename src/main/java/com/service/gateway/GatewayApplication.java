package com.service.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author : pc
 * @date : 2020/4/28
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GatewayApplication.class);
    }
}
