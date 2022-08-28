package com.example.LearningJava.EventListener.Event;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@EnableAsync
@Component
public class AuditEventHandler {

    @EventListener
    public void handleEvent(AuditEvent event) {
        log.info(event.toString());
    }

}

