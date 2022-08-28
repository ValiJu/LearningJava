package com.example.LearningJava.EventListener.Event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class AuditEventPublisher {

  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  public void publishEvent(String message) {
    applicationEventPublisher.publishEvent(new AuditEvent<>(message));
  }
}