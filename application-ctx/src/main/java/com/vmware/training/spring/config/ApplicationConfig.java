package com.vmware.training.spring.config;

import com.vmware.training.spring.service.PrintService;
import com.vmware.training.spring.service.StatusService;
import com.vmware.training.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Value("${app.show-fullname}")
    private boolean showFullName;

    @Value("${app.status-message}")
    private String statusMessage;

    @Value("${app.status-message-dev}")
    private String statusMessageDev;

    @Autowired
    UserService userService;

    @Autowired
    StatusService statusService;

    @Bean
    public UserService userService(){
        return new UserService(showFullName);
    }

    @Profile("!dev")
    @Bean
    public StatusService statusService(){
        return new StatusService(statusMessage);
    }

    @Profile("dev")
    @Bean
    public StatusService statusServiceDev(){
        return new StatusService(statusMessageDev);
    }

    @Bean
    public PrintService printService(){
        return new PrintService(userService, statusService);
    }
}