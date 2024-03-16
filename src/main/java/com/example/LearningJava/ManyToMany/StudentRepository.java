package com.example.LearningJava.ManyToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "students") // for spring data rest -> default is /studentEntities
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}


