package com.vmware.training.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
@ComponentScan(basePackages = {"com.vmware.training.spring"})
@EnableAspectJAutoProxy
public class ApplicationConfig {

}
