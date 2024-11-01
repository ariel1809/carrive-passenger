package com.manage.carrivepassenger.configuration;

import com.manage.carrivepassenger.security.JwtRequestFilter;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            String token = JwtRequestFilter.passenger.getToken();
            template.header("Authorization", "Bearer " + token);
        };
    }
}
