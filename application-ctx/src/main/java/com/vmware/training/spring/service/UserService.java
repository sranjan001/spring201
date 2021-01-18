package com.vmware.training.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class UserService {

    @Value("${app.show-fullname}")
    private boolean showFullName;

    public UserService() {

    }

    @PostConstruct
    public void postConstruct(){
        System.out.println(" Post Construct: " + this.getClass().getName() );
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println(" Pre Destroy: " + this.getClass().getName());
    }

    public String getName(String firstName, String lastName){
        if(showFullName) {
            return firstName + ", " + lastName;
        } else {
            return firstName;
        }
    }
}
