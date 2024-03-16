package com.example.LearningJava.paginationAndSorting;

import com.example.LearningJava.Transactional.RandomEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SomeController {
    private final SomeService someService;

    //http://localhost:8080/randomEntities?page=0&size=1
    @GetMapping("randomEntities")
    public Page<RandomEntity> getRandomEntities(@RequestParam int page, @RequestParam int size){
        return someService.getRandomEntities(page, size);
    }
}
