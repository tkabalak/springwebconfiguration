package com.exercises.spring.springproject04.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.stereotype.Component;

@Component
public class LoggerService {
    private final Logger logger = LoggerFactory.getLogger("");

    public void log(String log, Level level){
        if (level == Level.DEBUG){
            logger.debug(log);
        }
    }

}
