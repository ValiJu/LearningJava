package com.example.LearningJava.stackImplementations;

import com.example.LearningJava.nodes.Node;
import lombok.Data;

@Data
public class StackWithListImplementation {
    private Node head;
    private int capacity, size = 0;

    public StackWithListImplementation(int capacity) {
        this.head = null;
        this.capacity = capacity;

    }


    public void push(int val) {
        if (!isFull()) {
            Node newNode = new Node(val);
            newNode.setNext(head);
            this.head = newNode;
            this.size++;
        } else {
            System.out.println("Stack is full");
        }

    }

    public int pop() {
        if (!isEmpty()) {
            Node aux = this.head;
            this.head = this.head.getNext();
            aux.setNext(null);
            this.size--;
            return aux.getVal();
        }
        System.out.println("Stack is empty");
        return -1;

    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }


    public void print() {
        for (Node i = this.head; i != null; i = i.getNext()) {
            System.out.println(i.getVal());
        }
    }

}
