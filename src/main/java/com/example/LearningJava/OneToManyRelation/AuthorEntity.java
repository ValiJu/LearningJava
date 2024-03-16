package com.example.LearningJava.OneToManyRelation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER) // fetchType must be set per entity
    private List<BookEntity> books;

    public String toString() {
        return "AuthorEntity(id=" + this.getId() + ", name=" + this.getName() + ", books=" + ")";
    }
}
