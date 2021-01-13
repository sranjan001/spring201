package com.vmware.training.spring.config;

import com.vmware.training.spring.service.PrintService;
import com.vmware.training.spring.service.StatusService;
import com.vmware.training.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Principal;

@Configuration
public class ApplicationConfig {

    @Autowired
    UserService userService;

    @Autowired
    StatusService statusService;

    @Bean
    public UserService userService(){
        return new UserService("Josh", "Long", true);
    }

    @Bean
    public StatusService statusService(){
        return new StatusService("Hi, I am in US!!");
    }

    @Bean
    public PrintService printService(){
        return new PrintService(userService, statusService);
    }
}
