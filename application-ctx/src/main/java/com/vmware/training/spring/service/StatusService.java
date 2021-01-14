package com.vmware.training.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Value("${app.status-message}")
    private String statusMessage;

    public StatusService(){

    }

    public String getStatusMessage(){
        return statusMessage;
    }
}
