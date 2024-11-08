package org.example;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    /*insert into BST and return root*/
    public Node insert(Node root, int value) {
        //base case
        if (root == null) {
            root = new Node(value);
            return root;
        }
        //insert into left subtree
        if (value < root.value) {
            root.left = insert(root.left, value);
        }
        //insert into right subtree
        else if (value > root.value) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    /*search for a given key if found, return the node else return null*/
    public Node search(int value) {
        Node current = root;
        while (current != null) {
            if (value == current.value) {
                return current;
            } else if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    /*delete node with given key if found, else do nothing.return root*/
    public Node delete(Node root, int value) {
        //base case
        if (root == null) {
            return null;
        }

        if (value == root.value) {
            //if no child presents
            if (root.left == null && root.right == null) {
                return null;
            }
            //if only left child presents
            else if (root.right == null) {
                return root.left;
            }
            //if only right child presents
            else if (root.left == null) {
                return root.right;
            }
            //if both children presents
            else {
                Node successor = findSuccessor(root);
                root.value = successor.value;
                root.right = delete(root.right, successor.value);
            }
        }
        //traverse left subtree to delete node
        else if (value < root.value) {
            root.left = delete(root.left, value);
        }
        //traverse right subtree to delete node
        else {
            root.right = delete(root.right, value);
        }

        return root;
    }

    /*method to find the successor*/
    private Node findSuccessor(Node root) {
        Node current = root.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

}
