package com.example.LearningJava.OneToManyRelation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)  // fetchType must be set per entity
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    public String toString() {
        return "BookEntity(id=" + this.getId() + ", title=" + this.getTitle() + ", author=" + ")";
    }
}
