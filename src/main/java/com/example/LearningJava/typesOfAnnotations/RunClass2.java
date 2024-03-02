package com.example.LearningJava.typesOfAnnotations;

import com.example.LearningJava.messageDecodingUsingAnnotations.enumm.Position;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Data
@EveryPossibleFieldsAnnotation(intValue = 2, stringValue = "two", classValue = RunClass2.class,
                               stringArray = {"1","2","3"}, enumValue = Position.RIGHT, intArray = {1,2})
public class RunClass2 {


    private String a;
    private String b;
    private String c;

    /////////////////////////////////////////////// field annotation
    @Getter
    @Setter
    @FieldAnnotation(mustContain = "annotationMagic")
    private String patternField;

    ////////////////////////////////////////////// constructor annotation
    @ConstructorAnnotation()
    public RunClass2() {

    }

    @ConstructorAnnotation(numberOfArguments = 1)
    public RunClass2(String a) {
        this.a = a;
    }

    @ConstructorAnnotation(numberOfArguments = 2)
    public RunClass2(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @ConstructorAnnotation(numberOfArguments = 3)
    public RunClass2(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //////////////////////////////////////////////  method annotation
    @MethodAnnotation(deprecated = true)
    public void deprecatedMethod() {
        System.out.println("Deprecated message");
    }

    public void method() {
        System.out.println("message");
    }

    //////////////////////////////////////////////  class annotation
    @Component
    @ClassAnnotaion(clasification = "stage1")
    public class Class1 implements IClass {

    }

    @Component
    @ClassAnnotaion(clasification = "stage1")
    public class Class2 implements IClass {

    }

    @Component
    @ClassAnnotaion(clasification = "stage2")
    public class Class3 implements IClass {

    }

    @Component
    @ClassAnnotaion(clasification = "stage2")
    public class Class4 implements IClass {

    }

    public interface IClass {

    }

    @Component
    @RequiredArgsConstructor
    public class ClassExample {
        private final List<IClass> classes;

        @PostConstruct
        public void run() {
            //runClassAnnotationExample();
        }

        private void runClassAnnotationExample() {
            List<IClass> stage1List = classes.stream()
                    .filter(classInstance -> {
                        ClassAnnotaion annotation = classInstance.getClass().getAnnotation(ClassAnnotaion.class);
                        return annotation != null && annotation.clasification().equals("stage1");
                    }).toList();
            System.out.println("Stage1 classes");
            stage1List.forEach(classInstance -> System.out.println(classInstance.getClass().getSimpleName()));
        }
    }

    @PostConstruct
    @SneakyThrows
    public void run() {
        //runMethodAnnotationExample();
        //runConstructorAnnotationExample();
        runFieldAnnotationExample();
    }

    @SneakyThrows
    private void runFieldAnnotationExample() {
        RunClass2 runClass2 = new RunClass2();
        runClass2.setPatternField("randomValueWithAnnotationMagic");
        List<Field> fields = List.of(runClass2.getClass().getDeclaredFields());
        fields.stream().filter(field -> {
            return field.isAnnotationPresent(FieldAnnotation.class);
        }).forEach(field -> {
            FieldAnnotation fieldAnnotation = field.getAnnotation(FieldAnnotation.class);
            if (!runClass2.getPatternField().contains(fieldAnnotation.mustContain())) {
                System.out.println(runClass2.getPatternField() + " does not include sequence " + fieldAnnotation.mustContain());
            }else{
                System.out.println(runClass2.getPatternField() + " has the pattern");
            }
        });

    }

    private void runMethodAnnotationExample() throws IllegalAccessException, InvocationTargetException {
        List<Method> deprecatedMethods = Arrays.stream(RunClass2.class.getMethods()).filter(method -> {
            MethodAnnotation annotation = method.getAnnotation(MethodAnnotation.class);
            return annotation != null && annotation.deprecated();
        }).toList();
        for (Method method : deprecatedMethods) {
            method.invoke(new RunClass2());
        }
    }

    @SneakyThrows
    private void runConstructorAnnotationExample() {
        List<RunClass2> list = new ArrayList<>();
        List<Constructor<?>> constructors = Arrays.stream(RunClass2.class.getConstructors())
                .filter(constructor -> {
                    ConstructorAnnotation annotation = constructor.getAnnotation(ConstructorAnnotation.class);
                    return annotation != null && annotation.numberOfArguments() == 1;
                }).toList();
        for (Constructor<?> constructor : constructors) {
            list.add((RunClass2) constructor.newInstance("a"));
        }
        System.out.println(list);

    }
}
