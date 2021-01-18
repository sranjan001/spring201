package com.vmware.training.spring.service;

import com.vmware.training.spring.aspect.MethodLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PrintService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintService.class);
    private final StatusService statusService;
    private final UserService userService;
    private TimeServiceInt timeService;

    public PrintService(UserService userService, StatusService statusService){
        this.statusService = statusService;
        this.userService = userService;
    }

    @Autowired
    @Qualifier("timeService24Hr")
    public void setTimeService(TimeServiceInt timeService) {
        this.timeService = timeService;
    }

    @MethodLogger
    public boolean printStatusMessage(String firstName, String lastName){
        String output = userService.getName(firstName, lastName) + " - " + statusService.getStatusMessage();

        if(timeService != null) {
            LOGGER.info("Current Time: " + timeService.getTime());
        }

        LOGGER.info(output);
        return true;

    }
}
