package com.vmware.training.spring.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeService {
    private static final DateTimeFormatter FORMATTER_12 = DateTimeFormatter.ofPattern("hh:mm:ss a");

    public String getTime() {
        LocalDateTime now = LocalDateTime.now();
        return FORMATTER_12.format(now);
    }
}
