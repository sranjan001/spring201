package com.vmware.training.spring.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
//@Primary
@Qualifier("timeService12Hr")
public class TimeService implements TimeServiceInt {
    private static final DateTimeFormatter FORMATTER_12 = DateTimeFormatter.ofPattern("hh:mm:ss a");

    @PostConstruct
    public void postConstruct(){
        System.out.println(" Post Construct: " + this.getClass().getName() );
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println(" Pre Destroy: " + this.getClass().getName());
    }

    public String getTime() {
        LocalDateTime now = LocalDateTime.now();
        return FORMATTER_12.format(now);
    }
}
