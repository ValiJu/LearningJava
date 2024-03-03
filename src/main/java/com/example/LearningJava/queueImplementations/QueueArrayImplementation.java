package com.example.LearningJava.queueImplementations;

import lombok.Data;

@Data
public class QueueArrayImplementation {
    private int size;
    private int[] array;
    private int front, rear;
    private int nr = 0;

    public QueueArrayImplementation(int size) {
        this.rear = -1;
        this.front = -1;
        this.size = size;
        this.array = new int[size];
    }

    public void enQueue(int val) {
        if (isEmpty()) {
            this.array[this.front + 1] = val;
            this.front = this.front + 1;
            this.rear = rear + 1;
            this.nr++;
        } else if (!isFull()) {
            this.rear = (this.rear + 1) % (this.size);
            this.array[this.rear] = val;
            this.nr++;
        } else {
            System.out.println("queue is full");
        }
    }

    public int deQueue() {
        if (this.nr == 1) {
            int aux = this.front;
            this.array[this.front] = 0;
            this.front = -1;
            this.rear = -1;
            this.nr--;
            return this.array[aux];
        } else {
            this.array[this.front] = 0;
            this.front = this.front + 1;
            this.nr--;
            return this.array[this.front - 1];
        }
    }

    public boolean isEmpty() {
        return this.front == -1;
    }

    public boolean isFull() {
        return this.size == this.nr;
    }

    public void print() {
        for (int j : this.array) {
            if (j != 0) {
                System.out.println(j);
            }
        }
    }

    public int getRearValue() {
        if (rear == -1) {
            return 0;
        }
        return this.array[this.rear];
    }

    public int getFrontValue() {
        if (rear == -1) {
            return 0;
        }
        return this.array[this.front];
    }

}
