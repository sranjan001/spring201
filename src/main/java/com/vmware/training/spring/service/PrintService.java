package com.vmware.training.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class PrintService {
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

    public void printStatusMessage(String firstName, String lastName){
        String output = userService.getName(firstName, lastName) + " - " + statusService.getStatusMessage();

        if(timeService != null) {
            System.out.println("Current Time: " + timeService.getTime());
        }
        System.out.println(output);

    }
}
