package com.example.LearningJava.nodes;

import lombok.Data;

@Data
public class Node {
    private int val;
    private Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }

}