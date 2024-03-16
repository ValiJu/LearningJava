package com.example.LearningJava.OneToOneRelation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RunClassOtO {

    private final PassportRepository passportRepository;
    private final PersonRepository personRepository;

    //@PostConstruct
    public void run() {
        PassportEntity passportEntity = PassportEntity.builder().number("13").build();
        PersonEntity personEntity = PersonEntity.builder().name("Valii").build();

        //save PersonEntity
        personEntity.setPassport(passportEntity);   //double relation setting
        passportEntity.setPerson(personEntity);     //double relation setting
        personRepository.save(personEntity);

        //save PassportEntity
        PassportEntity passportEntity1 = PassportEntity.builder().number("14").build();
        PersonEntity personEntity1 = PersonEntity.builder().name("Iuli").build();

        personRepository.save(personEntity1);       // personEntity must be already present into the database before saving passport
        passportEntity1.setPerson(personEntity1);
        passportRepository.save(passportEntity1);

        List<PersonEntity> persons = personRepository.findAll();
        List<PassportEntity> passports = passportRepository.findAll();
        Optional<PassportEntity> byPersonId = passportRepository.findByPersonId(persons.get(0).getId());
        Optional<PersonEntity> byPassportId = personRepository.findByPassportId(passports.get(0).getId());

//      OBS: The fk key is placed only in PassportEntity table (the mappedBy is placed in PersonEntity)
        
    }
}
