package com.example.LearningJava.list;

import com.example.LearningJava.nodes.Node;
import lombok.Data;

@Data
public class Lista {
    private Node head;

    public Lista(Node head) {
        this.head = head;
    }

    public Lista() {

    }

    public void add(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        Node i;
        for (i = head; i.getNext() != null; i = i.getNext());
        i.setNext(node);
    }

    public void addNodeAfterNodeWithValue(Node node, int val) {
        for (Node i = head; i != null; i = i.getNext()) {
            if (i.getVal() == val) {
                node.setNext(i.getNext());
                i.setNext(node);
            }
        }
    }

    public void print() {
        for (Node i = head; i != null; i = i.getNext()) {
            System.out.println(i.getVal());
        }
    }
}