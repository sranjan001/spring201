package com.vmware.training.spring.config;

import com.vmware.training.spring.service.TimeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
@ComponentScan(basePackages = {"com.vmware.training.spring"})
public class ApplicationConfig {

}
