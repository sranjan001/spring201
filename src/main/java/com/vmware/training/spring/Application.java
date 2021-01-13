package com.vmware.training.spring;

import com.vmware.training.spring.service.PrintService;
import com.vmware.training.spring.service.StatusService;
import com.vmware.training.spring.service.UserService;

public class Application {

    public static void main(String[] args) {
        UserService userService = new UserService("Josh", "Long", false);
        StatusService statusService = new StatusService("Hey I am in US !!!");

        PrintService printService = new PrintService(userService, statusService);
        printService.printStatusMessage();
    }
}
