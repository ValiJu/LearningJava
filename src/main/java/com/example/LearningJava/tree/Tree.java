package com.example.LearningJava.tree;

import com.example.LearningJava.nodes.TreeNode;
import com.example.LearningJava.stackImplementations.StackWithTreeImplementation;
import lombok.Data;

@Data
public class Tree {
    private TreeNode root;

    public Tree(TreeNode treeNode) {
        this.root = treeNode;
    }

    public static void recursiveTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.getVal());
            recursiveTraversal(treeNode.getLeft());
            recursiveTraversal(treeNode.getRight());
        }
    }

    public void RSDTraversal() {
        StackWithTreeImplementation st = new StackWithTreeImplementation(100);
        while (true) {
            while (this.root != null) {
                System.out.println(this.root.getVal());
                st.push(this.root);
                this.root = this.root.getLeft();

            }
            if (st.isEmpty()) break;
            this.root = st.pop();
            this.root = this.root.getRight();
        }
    }
}
