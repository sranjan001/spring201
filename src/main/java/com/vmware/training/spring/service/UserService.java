package com.vmware.training.spring.service;

public class UserService {
    private final boolean showFullName;

    public UserService(boolean showFullName){
        this.showFullName = showFullName;
    }

    public String getName(String firstName, String lastName){
        if(showFullName) {
            return firstName + ", " + lastName;
        } else {
            return firstName;
        }
    }
}
