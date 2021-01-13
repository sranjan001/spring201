package com.vmware.training.spring.service;

public class UserService {
    private final boolean showFullName;
    private final String firstName;
    private final String lastName;

    public UserService(String firstName, String lastName, boolean showFullName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.showFullName = showFullName;
    }

    public String getName(){
        if(showFullName) {
            return firstName + ", " + lastName;
        } else {
            return firstName;
        }
    }
}
