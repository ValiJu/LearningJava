package com.example.LearningJava.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
public class RunClassTransactional {
    private final RandomRepository randomRepository;

//    @PostConstruct
    public void run() throws InterruptedException {
//        saveTransactional(); // nothing is saved
//        save();              // entity is saved
        saveConcurrently();
    }

    private void saveConcurrently() throws InterruptedException {
        randomRepository.deleteAll();
        randomRepository.save(RandomEntity.builder().name("Alice").sum(1000L).build());
        randomRepository.save(RandomEntity.builder().name("Bob").sum(1500L).build());

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> makeTransaction("Alice", -100L));
            //threads[i].join();
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> makeTransaction("Bob", -200L));
            //threads[i].join();
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        randomRepository.findAll().forEach(randomEntity -> System.out.println(randomEntity.getName() + ": " + randomEntity.getSum()));
    }

    @Transactional
    //should take care of atomicity and concurrency
    public void makeTransaction(String name, Long sum) {

        RandomEntity randomEntity = randomRepository.findByName(name);
        if (randomEntity != null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            randomEntity.setSum(randomEntity.getSum() + sum);
            randomRepository.save(randomEntity);
            System.out.println("[" + name + "] Tranzacție efectuată cu succes. Sold nou: " + randomEntity.getSum());
        } else {
            System.out.println("Contul pentru " + name + " nu a fost găsit.");
        }
    }

    @Transactional
    public void saveTransactional() {
        RandomEntity randomEntity = RandomEntity.builder().name("saveTransactional").build();
        randomRepository.save(randomEntity);
        throw new RuntimeException();
    }

    public void save() {
        RandomEntity randomEntity = RandomEntity.builder().name("save").build();
        RandomEntity randomEntity1 = RandomEntity.builder().name("saveTransactional").build();
        randomRepository.save(randomEntity1);
        randomRepository.save(randomEntity);
        throw new RuntimeException();
    }

//    * propagation - Specifică modul în care trebuie să se comporte tranzacția în cazul în care metoda curentă este apelată într-o altă tranzacție. Valorile posibile includ:
//
//    REQUIRED (implicit): Dacă există o tranzacție curentă, metoda se va alătura acesteia. Dacă nu există o tranzacție, se va crea una nouă.
//            REQUIRES_NEW: O nouă tranzacție este întotdeauna creată pentru executarea metodei, iar orice tranzacție curentă este suspendată temporar.
//    * isolation - Specifică nivelul de izolare al tranzacției. Valorile posibile includ:
//
//    DEFAULT (implicit): Nivelul de izolare implicit al bazei de date este folosit.
//    READ_UNCOMMITTED: Alte tranzacții pot vedea modificările necomise (necomise = neconfirmate) de tranzacția curentă.
//    READ_COMMITTED: Alte tranzacții pot vedea doar modificările comise de tranzacția curentă.
//    REPEATABLE_READ: Alte tranzacții nu pot vedea modificările necomise și pot citi aceleași date multiple ori în cadrul aceleiași tranzacții.
//    SERIALIZABLE: Cel mai strict nivel de izolare, asigurându-se că nicio altă tranzacție nu poate accesa datele modificate de tranzacția curentă.
//    * readOnly - Indică dacă tranzacția este doar pentru citire. Dacă este setat la true, atunci nu se permit modificări în cadrul tranzacției.
//
//    * timeout - Specifică timpul maxim în secunde în care tranzacția trebuie să fie finalizată. Dacă timpul este depășit, tranzacția este abandonată.
//
//    * rollbackFor și rollbackForClassName - Specifică tipurile de excepții pentru care tranzacția ar trebui să fie anulată și rollback-ul să fie efectuat. Poate fi o listă de clase de excepții sau o singură clasă.
//
//    * noRollbackFor și noRollbackForClassName - Specifică tipurile de excepții pentru care tranzacția nu ar trebui să fie anulată și rollback-ul să nu fie efectuat. Poate fi o listă de clase de excepții sau o singură clasă.
}
