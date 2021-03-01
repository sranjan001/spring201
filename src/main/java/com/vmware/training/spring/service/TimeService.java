package com.vmware.training.spring.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
//@Primary
@Qualifier("timeService12Hr")
public class TimeService implements TimeServiceInt {
    private static final DateTimeFormatter FORMATTER_12 = DateTimeFormatter.ofPattern("hh:mm:ss a");

    public String getTime() {
        LocalDateTime now = LocalDateTime.now();
        return FORMATTER_12.format(now);
    }
}
