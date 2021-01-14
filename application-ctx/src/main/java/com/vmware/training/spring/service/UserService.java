package com.vmware.training.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Value("${app.show-fullname}")
    private boolean showFullName;

    public UserService() {

    }

    public String getName(String firstName, String lastName){
        if(showFullName) {
            return firstName + ", " + lastName;
        } else {
            return firstName;
        }
    }
}
