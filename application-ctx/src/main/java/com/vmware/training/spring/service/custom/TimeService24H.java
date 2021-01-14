package com.vmware.training.spring.service.custom;

import com.vmware.training.spring.service.TimeServiceInt;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Qualifier("timeService24Hr")
public class TimeService24H implements TimeServiceInt {
    private static final DateTimeFormatter FORMATTER_24 = DateTimeFormatter.ofPattern("HH:mm:ss");

    public String getTime() {
        LocalDateTime now = LocalDateTime.now();
        return FORMATTER_24.format(now);
    }
}
