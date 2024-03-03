package com.example.LearningJava.stackImplementations;

import lombok.Data;

@Data
public class StackWithArrayImplementation {
    private int capacity;
    private int[] array;
    private int top = -1;

    public StackWithArrayImplementation(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public void push(int val) {
        if (!isFull()) {
            this.top++;
            this.array[this.top] = val;
        } else {
            resize();
            this.top++;
            this.array[this.top] = val;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
        }
        this.top--;
        return this.array[this.top + 1];

    }

    public int top() {
        return this.array[this.top];
    }

    public boolean isFull() {
        return this.top == this.capacity - 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public void print() {
        for (int i = this.top; i >= 0; i--) {
            System.out.println(this.array[i]);
        }
    }

    public void resize() {
        this.capacity = 2 * this.capacity;
        int[] vector = new int[capacity];

        for (int i = 0; i < this.capacity / 2; i++) {
            vector[i] = this.array[i];
        }
        this.array = vector;
    }

}

