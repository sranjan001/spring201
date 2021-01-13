package com.vmware.training.spring.service;

public class PrintService {
    private final StatusService statusService;
    private final UserService userService;

    public PrintService(UserService userService, StatusService statusService){
        this.statusService = statusService;
        this.userService = userService;
    }

    public void printStatusMessage(){
        String output = userService.getName() + " - " + statusService.getStatusMessage();
        System.out.println(output);
    }
}
