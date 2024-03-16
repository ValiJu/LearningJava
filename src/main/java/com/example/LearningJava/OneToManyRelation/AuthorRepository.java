package com.example.LearningJava.OneToManyRelation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    Optional<AuthorEntity> findByBooksId(Long id); // need to match exacly the name of the field in AuthorEntity books not book
}
