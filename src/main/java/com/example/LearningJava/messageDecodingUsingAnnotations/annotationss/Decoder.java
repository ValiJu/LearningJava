package com.example.LearningJava.messageDecodingUsingAnnotations.annotationss;

import com.example.LearningJava.messageDecodingUsingAnnotations.matchers.Matcher;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Decoder {
    int NOT_SET = 0;

    int start() default NOT_SET;

    int end() default NOT_SET;

    Class<? extends Matcher> matcher() default Matcher.class;
}
