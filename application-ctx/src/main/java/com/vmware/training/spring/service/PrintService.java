package com.vmware.training.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrintService {
    private final StatusService statusService;
    private final UserService userService;
    private TimeService timeService;

    public PrintService(UserService userService, StatusService statusService){
        this.statusService = statusService;
        this.userService = userService;
    }

    @Autowired
    public void setTimeService(TimeService timeService) {
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
