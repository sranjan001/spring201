package com.vmware.training.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:application.properties", "classpath:application-dev.properties"})
@ComponentScan(basePackages = {"com.vmware.training.spring"})
public class ApplicationConfig {


}
