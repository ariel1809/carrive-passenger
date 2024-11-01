package com.manage.carrivepassenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.manage.carriveutility.repository"})
@EntityScan("com.manage.carrive")
@EnableFeignClients
public class CarrivePassengerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarrivePassengerApplication.class, args);
    }

}
