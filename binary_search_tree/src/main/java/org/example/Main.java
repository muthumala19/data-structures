package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 50;
        Random random = new Random();
        BinarySearchTree bst = new BinarySearchTree();
        Node root = bst.getRoot();

        //insert into bst
        for (int i = 0; i < n; i++) {
            // Generate a random number between 0 and 1000 (inclusive)
            int randomNumber = random.nextInt(1001);
            bst.insert(root, randomNumber);
        }
    }
}