package com.vmware.training.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PrintService {
    private final StatusService statusService;
    private final UserService userService;
    private TimeServiceInt timeSrv;

    public PrintService(UserService userService, StatusService statusService){
        this.statusService = statusService;
        this.userService = userService;
    }

    @Autowired
    @Qualifier("timeService24Hr")
    public void setTimeSrv(TimeServiceInt timeSrv) {
        this.timeSrv = timeSrv;
    }

    public void printStatusMessage(String firstName, String lastName){
        String output = userService.getName(firstName, lastName) + " - " + statusService.getStatusMessage();

        if(timeSrv != null) {
            System.out.println("Current Time: " + timeSrv.getTime());
        }
        System.out.println(output);

    }
}
