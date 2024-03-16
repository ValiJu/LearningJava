package com.example.LearningJava.OneToManyRelation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByAuthorId(Long id);
}
