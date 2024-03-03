package com.example.LearningJava.stackImplementations;

import com.example.LearningJava.nodes.NodeA;
import com.example.LearningJava.nodes.TreeNode;
import lombok.Data;

@Data
public class StackWithTreeImplementation {
    private NodeA head;
    private int capacity, size = 0;

    public StackWithTreeImplementation(int capacity) {
        this.head = null;
        this.capacity = capacity;

    }

    public void push(TreeNode val) {
        if (!isFull()) {
            NodeA newNode = new NodeA(val);
            newNode.setNext(this.head);
            this.head = newNode;
            this.size++;
        } else {
            System.out.println("Stack is full");
        }

    }

    public TreeNode pop() {
        if (!isEmpty()) {
            NodeA aux = this.head;
            this.head = this.head.getNext();
            aux.setNext(null);
            this.size--;
            return aux.getVal();
        }
        System.out.println("Stack is empty");
        return null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }


    public void print() {
        for (NodeA i = this.head; i != null; i = i.getNext()) {
            System.out.println(i.getVal().getVal());
        }
    }

}
