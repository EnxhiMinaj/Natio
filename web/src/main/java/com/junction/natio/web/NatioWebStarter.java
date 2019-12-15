package com.junction.natio.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Anil Kumal on 12/2/2019.
 */
@SpringBootApplication(
        exclude = {DataSourceAutoConfiguration.class},
        scanBasePackages = {"com.junction"}
)
@EnableCaching
@Configuration
public class NatioWebStarter {

    public static void main(String[] args) {
        SpringApplication.run(NatioWebStarter.class, args);
    }



}



