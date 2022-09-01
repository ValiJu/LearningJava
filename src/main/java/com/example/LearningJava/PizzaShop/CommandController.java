package com.example.LearningJava.PizzaShop;

import com.example.LearningJava.PizzaShop.PizzaTypes.Pizza;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommandController {
    private final CommandService commandService;

    @PostMapping("command")
    public ResponseEntity<Pizza> processCommand(@RequestBody Command command) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        return new ResponseEntity<>(commandService.processCommand(command), HttpStatus.ACCEPTED);

    }
}
