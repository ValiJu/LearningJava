package com.example.LearningJava.OneToOneRelation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassportRepository extends JpaRepository<PassportEntity, Long> {

    Optional<PassportEntity> findByPersonId(Long id);

}
