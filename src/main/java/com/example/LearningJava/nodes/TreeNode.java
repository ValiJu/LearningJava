package com.example.LearningJava.nodes;

import lombok.Data;

@Data
public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
        left = null;
        right = null;
        this.val = val;
    }

}
