package com.example.LearningJava.messageDecodingUsingAnnotations.matchers;

public interface Matcher<T,V> {

    V match(T t);
}
