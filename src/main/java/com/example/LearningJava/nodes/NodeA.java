package com.example.LearningJava.nodes;

import lombok.Data;

@Data
public class NodeA {
    private TreeNode val;
    private NodeA next;

    public NodeA(TreeNode val) {
        this.val = val;
        this.next = null;
    }

}
