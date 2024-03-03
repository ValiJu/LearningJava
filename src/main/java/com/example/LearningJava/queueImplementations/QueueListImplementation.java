package com.example.LearningJava.queueImplementations;

import com.example.LearningJava.nodes.Node;
import lombok.Data;

@Data
public class QueueListImplementation {
    private Node front, rear;
    private int size;

    public QueueListImplementation() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enQueue(int val) {
        if (isEmpty()) {
            Node nou = new Node(val);
            this.rear = nou;
            this.front = nou;
            this.size++;

        } else {
            Node nou = new Node(val);
            this.rear.setNext(nou);
            this.rear = nou;
            this.size++;

        }

    }

    public int deQueue() {
        if (isEmpty()) {
            return -1;
        }
        Node aux;
        aux = this.front;
        this.front = front.getNext();
        aux.setNext(null);
        this.size--;
        return aux.getVal();
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public void print() {
        for (Node i = this.front; i != null; i = i.getNext()) {
            System.out.println(i.getVal());
        }
    }

    public int getRear() {
        return this.rear.getVal();
    }

    public int getFront() {
        return this.front.getVal();
    }

}
