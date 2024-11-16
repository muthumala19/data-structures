package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 50;
        Random random = new Random();
        BinarySearchTree bst = new BinarySearchTree();
        Node root = null; // Initialize a local root variable

        // Insert into BST
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(1001);
            root = bst.insert(root, randomNumber); // Update the local root
        }

        //inorder traversal
        bst.inorderTraversal(root); // Use the local root for traversal
    }
}
