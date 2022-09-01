package com.example.LearningJava.DesignPatterns.Behavioral.Observer;

import org.junit.Test;

public class ObserverTest {
    @Test
    public void testObserver(){
        Subject subject = new Subject(15);
        Observer octal = new OctalObserver(subject);
        Observer hex = new HexObserver(subject);
        Observer binary = new BinaryObserver(subject);

        subject.changeState(14);
    }
}
