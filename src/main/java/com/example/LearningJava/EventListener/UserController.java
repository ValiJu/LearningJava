package com.example.LearningJava.EventListener;


import com.example.LearningJava.EventListener.Event.AuditEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private AuditEventPublisher auditEventPublisher;

  @PostMapping
  public String register(@RequestBody User user) {
    auditEventPublisher.publishEvent("Received User post with name = " + user.getUserName());
    return "Success";
  }
}
