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
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    // we have a parent and a child, cascade is used for parent, and orphanRemoval for orphan child
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    // mappedBy used to say that the Passport will have the foreign key
    private PassportEntity passport;                                                      // and the corresponding field is "person" inside Passport

    public String toString() {
        return "PersonEntity(id=" + this.getId() + ", name=" + this.getName() + ", passportId=" + this.getPassport().getId() + ")";
    }
}

//    În Hibernate, cascade este un mecanism care permite propagarea operațiilor de salvare, actualizare, ștergere etc. de la o entitate părinte la o entitate copilă sau invers, în funcție de modul în care este configurat.
//
//        CascadeType.ALL:----------
//        Acest tip include toate operațiile, adică PERSIST (salvare), MERGE (actualizare), REMOVE (ștergere) și REFRESH (reîmprospătare). Este cel mai cuprinzător tip de cascade.

//        CascadeType.PERSIST:-----------
//        Realizează propagarea operației de salvare (persist). Este util când vrei ca o entitate copil să fie salvată automat atunci când este salvată entitatea părinte.

//        CascadeType.MERGE:------
//        Realizează propagarea operației de actualizare (merge). Este util pentru a actualiza entitatea copilă atunci când este actualizată entitatea părinte.

//        CascadeType.REMOVE:
//        Realizează propagarea operației de ștergere (remove). Este util când dorești să ștergi automat entitatea copilă atunci când ștergi entitatea părinte.
//
//        CascadeType.REFRESH:
//        Realizează propagarea operației de reîmprospătare (refresh). Este util când vrei ca entitatea copilă să fie reîmprospătată automat atunci când este reîmprospătată entitatea părinte.
//
//        CascadeType.DETACH:
//        Realizează propagarea operației de detach (detach). Este util când dorești să detasezi entitatea copilă atunci când este detasată entitatea părinte.
