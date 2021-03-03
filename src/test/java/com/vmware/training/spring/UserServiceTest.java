package com.vmware.training.spring;

import com.vmware.training.spring.config.ApplicationConfig;
import com.vmware.training.spring.service.PrintService;
import com.vmware.training.spring.service.TimeService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserServiceTest {

    @Test
    public void printStatusTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PrintService printService = applicationContext.getBean(PrintService.class);

        //This is for overiding the default service impl with a dummy impl.
        TimeService timeService = new TimeService() {
            @Override
            public String getTime() {
                return "No time";
            }
        };

        printService.setTimeService(timeService);
        printService.printStatusMessage("Josh", "Long");
    }


}
