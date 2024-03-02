package com.example.LearningJava.typesOfAnnotations;

import com.example.LearningJava.messageDecodingUsingAnnotations.enumm.Position;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EveryPossibleFieldsAnnotation {
    int intValue() default 42;
    String stringValue() default "default";
    Class<?> classValue() default String.class;
    Position enumValue() default Position.NO_STATUS;
    int[] intArray() default {1, 2, 3};
    String[] stringArray() default {"one", "two", "three"};
}

