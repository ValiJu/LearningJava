package com.example.LearningJava;


import com.example.LearningJava.list.Lista;
import com.example.LearningJava.nodes.Node;
import com.example.LearningJava.nodes.TreeNode;
import com.example.LearningJava.queueImplementations.QueueArrayImplementation;
import com.example.LearningJava.queueImplementations.QueueListImplementation;
import com.example.LearningJava.stackImplementations.StackWithArrayImplementation;
import com.example.LearningJava.stackImplementations.StackWithListImplementation;
import com.example.LearningJava.stackImplementations.StackWithTreeImplementation;
import com.example.LearningJava.tree.Tree;

public class RunClass {

    public static void main(String[] args) {

        //treeExample();
        //listExample();
        //stackWithTreeImplementationExample();
        //stackWithListImplementationExample();
        //stackWithArrayImplementationExample();
        //queueWithListImplementation();
        queueArrayImplementation();


    }

    private static void queueArrayImplementation() {
        QueueArrayImplementation queue = new QueueArrayImplementation(5);
        queue.enQueue(10);
        queue.enQueue(3);
        queue.enQueue(3);
        queue.enQueue(11);
        queue.enQueue(12);
        queue.deQueue();
        System.out.println(queue.getFrontValue());
        queue.print();
    }

    private static void queueWithListImplementation() {
        QueueListImplementation queue = new QueueListImplementation();
        queue.enQueue(12);
        queue.enQueue(11);
        queue.enQueue(10);
        queue.deQueue();
        queue.print();
    }

    private static void stackWithArrayImplementationExample() {
        StackWithArrayImplementation stack = new StackWithArrayImplementation(4);

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(6);
        stack.print();
    }

    private static void stackWithListImplementationExample() {
        StackWithListImplementation stack = new StackWithListImplementation(100);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(5);
        stack.print();
    }

    private static void stackWithTreeImplementationExample() {
        StackWithTreeImplementation st = new StackWithTreeImplementation(4);
        st.push(new TreeNode(5));
        st.push(new TreeNode(6));
        st.pop();
        st.print();
    }

    private static void listExample() {
        Lista lista = new Lista();
        lista.add(new Node(1));
        lista.add(new Node(2));
        lista.add(new Node(3));
        lista.addNodeAfterNodeWithValue(new Node(10), 3);
        lista.print();
    }

    private static void treeExample() {
        TreeNode treNode1 = new TreeNode(1);

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNote7 = new TreeNode(7);

        TreeNode treeNode8 = new TreeNode(8);


        //       1
        //    2     3
        //  4   5 6   7
        //8
        Tree tree = new Tree(treNode1);
        tree.getRoot().setLeft(treeNode2);
        tree.getRoot().setRight(treeNode3);
        tree.getRoot().getLeft().setLeft(treeNode4);
        tree.getRoot().getLeft().setRight(treeNode5);
        tree.getRoot().getRight().setLeft(treeNode6);
        tree.getRoot().getRight().setRight(treeNote7);
        tree.getRoot().getLeft().getLeft().setLeft(treeNode8);

        Tree.recursiveTraversal(tree.getRoot());
        System.out.println("\n");
        tree.RSDTraversal();
    }
}
