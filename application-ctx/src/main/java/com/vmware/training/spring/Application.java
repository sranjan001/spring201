package com.vmware.training.spring;

import com.vmware.training.spring.config.ApplicationConfig;
import com.vmware.training.spring.service.PrintService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PrintService printService = applicationContext.getBean(PrintService.class);
        printService.printStatusMessage("Josh", "Long");
        applicationContext.close();
    }
}
