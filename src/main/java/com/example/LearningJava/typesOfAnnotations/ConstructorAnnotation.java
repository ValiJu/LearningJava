package com.example.LearningJava.typesOfAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.CONSTRUCTOR)
public @interface ConstructorAnnotation {
    int DEFAULT_NR_ARGS = 0;

    int numberOfArguments() default DEFAULT_NR_ARGS;
}
