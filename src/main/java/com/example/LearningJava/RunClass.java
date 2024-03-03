package com.example.LearningJava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RunClass {

    public interface Interface{
        int methodOne();
    }
    public static class ClassOne implements Interface{
        @Override
        public int methodOne() {
            return 0;
        }
    }

    @PostConstruct
    public void run() {
//        pairExample();
//        comparatorExample();
//        keyValueStoreExample();
//        genericsWithReflectionExample();
        wildcardExample();
    }

    private void wildcardExample() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);integerList.add(2);integerList.add(3);
        printList(integerList);
        List<String> stringList = new ArrayList<>();
        stringList.add("one");stringList.add("two");stringList.add("three");
        printList(stringList);
    }

    public static void printList(List<?> list) {
        list.add(null);            // null is the oly object that can be added to this kind of list
        for (Object element : list) {
//            list.add(new Object());   nothing can be added to this list, only if it is null
//            RunClass runClass = (RunClass) element;   is permitted but it will generate a ClassCastException
            System.out.println(element);
        }
    }

    private void genericsWithReflectionExample() {
        class GenericReflectionExample<T> {
            private T value;

            public T getValue() {
                return value;
            }

            public void setValue(T value) {
                this.value = value;
            }

            public Class<?> getType() {
                return value.getClass();
            }
        }

        GenericReflectionExample<String> stringGeneric = new GenericReflectionExample<>();
        stringGeneric.setValue("Hello");
        Class<?> type = stringGeneric.getType();
        System.out.println(type);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    private void keyValueStoreExample() {
        class KeyValueStore<K, V> {
            private final Map<K, V> store;

            public KeyValueStore() {
                this.store = new HashMap<>();
            }

            public void put(K key, V value) {
                store.put(key, value);
            }

            public V get(K key) {
                return store.get(key);
            }

            public static <T, U extends Number> double calculateAverage(KeyValueStore<T, U> keyValueStore) {
                double sum = 0;
                for (Number value : keyValueStore.store.values()) {
                    sum += value.doubleValue();
                }
                return sum / keyValueStore.store.size();
            }
        }

        KeyValueStore<String, Integer> integerStore = new KeyValueStore<>();
        integerStore.put("one", 1);
        integerStore.put("two", 2);
        integerStore.put("three", 3);

        int value = integerStore.get("two");
        System.out.println("Value for key 'two': " + value);

        double average = KeyValueStore.calculateAverage(integerStore);
        System.out.println("Average of values in the store: " + average);

        KeyValueStore<String, Double> doubleStore = new KeyValueStore<>();
        doubleStore.put("pi", 3.14159);
        doubleStore.put("e", 2.71828);

        double doubleValue = doubleStore.get("pi");
        System.out.println("Value for key 'pi': " + doubleValue);

        double doubleAverage = KeyValueStore.calculateAverage(doubleStore);
        System.out.println("Average of values in the store: " + doubleAverage);
    }

////////////////////////////////////////////////////////////////////////////////////////////////
    interface Comparator <T>{
        T getGrater(T t);
    }
    @AllArgsConstructor
    class Pipe implements Comparator<Pipe> {
        @Getter
        private int length;

        @Override
        public Pipe getGrater(Pipe pipe) {
            return this.length > pipe.getLength() ? this : pipe;
        }
    }
    private void comparatorExample() {
        int a = processOne(new ClassOne());
        ClassOne classOne = processTwo(new ClassOne());
        //String string = processOne(new String());  //not working

        List<Pipe> pipeList= new ArrayList<>();
        pipeList.add(new Pipe(12));
        pipeList.add(new Pipe(14));
        pipeList.add(new Pipe(9));

        System.out.println(getGreatest(pipeList));
    }

    public <T extends Comparator<T>> T getGreatest(List<T> list){
        T greatest = null;
        for (int i= 0; i< list.size() -1; i++){
            greatest = list.get(i).getGrater(list.get(i+1));
        }
        return greatest;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    private void pairExample() {
        class Pair <T extends String,U extends String>{
            private T first;
            private U second;

            public void setFirst(T first) {
                this.first = first;
            }

            public T getFirst() {
                return first;
            }

            public void setSecond(U second) {
                this.second = second;
            }

            public U getSecond() {
                return second;
            }
        }

        Pair<String, String> stringStringPair = new Pair<>();
        stringStringPair.setFirst("first");
        stringStringPair.setSecond("second");
        System.out.println(stringStringPair.getFirst() + " " + stringStringPair.getSecond());
    }

    public <T extends Interface> int processOne(T t){
        return t.methodOne();
    }

    public <T extends Interface> T processTwo(T t){
        return t;
    }
}
