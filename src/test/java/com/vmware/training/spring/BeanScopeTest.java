package com.vmware.training.spring;

import com.vmware.training.spring.config.ApplicationConfig;
import com.vmware.training.spring.service.PrintService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanScopeTest {

    @Test
    public void testPrototypeScope() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PrintService printService = applicationContext.getBean(PrintService.class);
        printService.printStatusMessage("Josh", "Long");

        PrintService printService1 = applicationContext.getBean(PrintService.class);

        Assertions.assertNotEquals(printService, printService1);
    }

    @Test
    public void testSingletonScope() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PrintService printService = applicationContext.getBean(PrintService.class);
        printService.printStatusMessage("Josh", "Long");

        PrintService printService1 = applicationContext.getBean(PrintService.class);

        Assertions.assertEquals(printService, printService1);
    }
}
