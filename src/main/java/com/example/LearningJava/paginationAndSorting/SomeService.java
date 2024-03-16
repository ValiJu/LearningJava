package com.example.LearningJava.paginationAndSorting;

import com.example.LearningJava.Transactional.RandomEntity;
import com.example.LearningJava.Transactional.RandomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SomeService {
    private final RandomRepository randomRepository;

    public Page<RandomEntity> getRandomEntities(int page, int size) {
        return randomRepository.findAll(PageRequest.of(page, size, Sort.by(Direction.DESC, "id")));
    }
}
