package org.example;

public class BinarySearchTree {
    private Node root;

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
        if (root == null) {
            return root;
        }

        if (value < root.value) {
            root.left = delete(root.left, value);
        } else if (value > root.value) {
            root.right = delete(root.right, value);
        } else { // Node to be deleted found
            if (root.left == null) {
                return root.right; // No left child, return right child
            } else if (root.right == null) {
                return root.left; // No right child, return left child
            }

            // Node has two children, find the successor (smallest in the right subtree)
            Node successor = findSuccessor(root);
            root.value = successor.value;
            root.right = delete(root.right, successor.value); // Remove the successor
        }
        return root;
    }

    /*method to find the successor*/
    private Node findSuccessor(Node node) {
        if (node.right != null) {
            // Case 1: Node has a right subtree
            Node current = node.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }

        // Case 2: Node does not have a right subtree
        Node successor = null;
        Node current = this.root;
        while (current != null) {
            if (node.value < current.value) {
                successor = current;  // Update successor
                current = current.left;
            } else if (node.value > current.value) {
                current = current.right;
            } else {
                break;
            }
        }
        return successor;
    }

    /*method to find the predecessor*/
    private Node findPredecessor(Node node) {
        // Case 1: Node has a left subtree
        if (node.left != null) {
            // Find the largest node in the left subtree (rightmost node)
            Node current = node.left;
            while (current.right != null) {
                current = current.right;
            }
            return current;
        }

        // Case 2: Node does not have a left subtree
        Node predecessor = null;
        Node current = this.root;  // Start from the root of the BST

        // Traverse the tree to find the predecessor
        while (current != null) {
            if (node.value > current.value) {
                predecessor = current;  // Update predecessor
                current = current.right;
            } else if (node.value < current.value) {
                current = current.left;
            } else {
                // Node is found, break the loop
                break;
            }
        }

        // Return the predecessor node
        return predecessor;
    }

    /*pre-order traversal*/
    public void preorderTraversal(Node root) {
        if (root != null) {
            System.out.println(root.value + ", "); // visit value
            preorderTraversal(root.left); //visit left subtree
            preorderTraversal(root.right); //visit right subtree
        }
    }

    /*in-order traversal*/
    public void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left); //visit left subtree
            System.out.print(root.value + ", "); // visit value
            inorderTraversal(root.right); //visit right subtree
        }
    }

    /*post-order traversal*/
    public void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left); //visit left subtree
            postorderTraversal(root.right); //visit right subtree
            System.out.println(root.value + ", "); // visit value
        }
    }

}
