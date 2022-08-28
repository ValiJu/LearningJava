package com.example.LearningJava.EventListener.Event;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@ToString
@Getter
public class AuditEvent<T> extends ApplicationEvent {
  private final T data;

  public AuditEvent(T data) {
    super(data);
    this.data = data;
  }
}
