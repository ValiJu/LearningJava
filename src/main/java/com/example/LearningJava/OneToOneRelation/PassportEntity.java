package com.example.LearningJava.OneToOneRelation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id") // used to set the column name for the foreign key of person
    private PersonEntity person;

    public String toString() {
        return "PassportEntity(id=" + this.getId() + ", number=" + this.getNumber() + ", personId=" + this.getPerson().getId() + ")";
    }
}
