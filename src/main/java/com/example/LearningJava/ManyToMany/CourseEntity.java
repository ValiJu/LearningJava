package com.example.LearningJava.ManyToMany;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "courses")
    private Set<StudentEntity> students = new HashSet<>();

    @Override
    public String toString() {
        return "CourseEntity(id=" + id + ", title=" + title + ")";
    }
}
