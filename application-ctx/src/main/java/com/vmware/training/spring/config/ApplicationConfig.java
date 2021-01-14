package com.vmware.training.spring.config;

import com.vmware.training.spring.service.PrintService;
import com.vmware.training.spring.service.StatusService;
import com.vmware.training.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource(value = {"classpath:application.properties", "classpath:application-dev.properties"})
public class ApplicationConfig {

    @Value("${app.show-fullname}")
    private boolean showFullName;

    @Value("${app.status-message}")
    private String statusMessage;

    @Autowired
    UserService userService;

    @Autowired
    StatusService statusService;

    @Bean
    public UserService userService(){
        return new UserService(showFullName);
    }

    @Bean
    public StatusService statusService(){
        return new StatusService(statusMessage);
    }

    @Bean
    @Scope("singleton")
    public PrintService printService(){
        return new PrintService(userService, statusService);
    }
}
