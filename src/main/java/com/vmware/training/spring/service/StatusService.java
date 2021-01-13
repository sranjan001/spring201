package com.vmware.training.spring.service;

public class StatusService {

    private final String statusMessage;

    public StatusService(String statusMessage){
        super();
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage(){
        return statusMessage;
    }
}
