package com.example.LearningJava.messageDecodingUsingAnnotations.annotationss;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE})
public @interface Length {
    int DEFAULT_LENGTH = 0;

    int length () default DEFAULT_LENGTH;
}
