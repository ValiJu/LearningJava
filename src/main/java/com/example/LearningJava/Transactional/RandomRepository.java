package com.example.LearningJava.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RandomRepository extends JpaRepository<RandomEntity, Long> {
    @Query("SELECT r FROM RandomEntity r WHERE r.name = :name")
    RandomEntity findByName(String name);
}
