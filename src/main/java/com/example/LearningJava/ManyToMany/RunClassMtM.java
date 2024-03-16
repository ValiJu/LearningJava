package com.example.LearningJava.ManyToMany;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class RunClassMtM {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    //@PostConstruct
    public void run() {
        CourseEntity courseEntity1 = CourseEntity.builder().title("Romanian").build();
        CourseEntity courseEntity2 = CourseEntity.builder().title("English").build();

        StudentEntity studentEntity1 = StudentEntity.builder().name("Vali").build();
        StudentEntity studentEntity2 = StudentEntity.builder().name("Iuli").build();

        Set<CourseEntity> courseEntities1 = Set.of(courseEntity1);
        Set<CourseEntity> courseEntities2 = Set.of(courseEntity2);


        studentEntity1.setCourses(courseEntities1);
        studentEntity2.setCourses(courseEntities2);

        studentRepository.save(studentEntity1);
        studentRepository.save(studentEntity2);

    }
}
