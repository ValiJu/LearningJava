package com.example.LearningJava.application;

import com.example.LearningJava.appuser.AppUser;
import com.example.LearningJava.appuser.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final AppUserService appUserService;

    @GetMapping("/listUsers")
    public List<AppUser> getUsers() {
        return appUserService.findUsers();
    }

    @GetMapping("/user/{email}")
    public AppUser getUser(@PathVariable String email) {
        Optional<AppUser> appUser = appUserService.findByEmail(email);
        return appUser.orElse(null);
    }
}
