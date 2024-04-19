/*
Name: Mahmued Ahmed Alardawi
ID: 2135209
Email: mmalardawi@stu.kau.edu.sa
Course: CPCS-204
Section: F1
Assignment: Binary Search Tree
Date: 11/2/2022
*/

import java.io.PrintWriter;
import java.util.*;

public class UberTree {
    private CaptainNode root;

    // Constructor 1
    public UberTree() {}

    // Constructor 2
    public UberTree(CaptainNode root) {
        this.root = root;
    }

    // Getters and setters
    public CaptainNode getRoot() {
        return root;
    }
    public void setRoot(CaptainNode root) {
        this.root = root;
    }

    // toString
    @Override
    public String toString() {
        return "UberTree{" +
                "root=" + root +
                '}';
    }

    // Traversal - Pre Order (root - left - right)
    public void preOrder(CaptainNode root) {
        if (root != null) {
            System.out.println("ID: " + root.getID());
            System.out.println("Name: " + root.getName());
            System.out.println("Available: " + root.isAvailable());
            System.out.println("Rating star: " + root.getRatingStars());
            System.out.println();
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void preOrder(CaptainNode root, PrintWriter output) {
        if (root != null) {
            output.println();
            output.println("\t\t\tID: " + root.getID());
            output.println("\t\t\tName: " + root.getName());
            output.println("\t\t\tAvailable: " + root.isAvailable());
            output.println("\t\t\tRating star: " + root.getRatingStars());
            output.println();
            output.println("----------------------------------------------------------------");
            preOrder(root.left, output);
            preOrder(root.right, output);
        }
    }

    // Traversal - In Order (left - root - right)
    public void inOrder(CaptainNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println("ID: " + root.getID());
            System.out.println("Name: " + root.getName());
            System.out.println("Available: " + root.isAvailable());
            System.out.println("Rating star: " + root.getRatingStars());
            System.out.println();
            inOrder(root.right);
        }
    }

    // Traversal - Post Order (left - right - root)
    public void postOrder(CaptainNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println("ID: " + root.getID());
            System.out.println("Name: " + root.getName());
            System.out.println("Available: " + root.isAvailable());
            System.out.println("Rating star: " + root.getRatingStars());
            System.out.println();
        }
    }

    // Searching
    public boolean searchTree(int id) {return searchTree(this.root, id);}
    private boolean searchTree(CaptainNode root, int id) {
        if (root == null)
            return false;

        if (id == root.getID())
            return true;
        else if (id < root.getID())
            return searchTree(root.left, id);
        else
            return searchTree(root.right, id);
    }

    // Insertion
    public void insert(CaptainNode captain) {
        this.root = insert(this.root, captain);
    }
    private CaptainNode insert(CaptainNode root, CaptainNode captain) {
        if (root == null)
            root = captain;
        else {
            if (captain.getID() < root.getID())
                root.left = insert(root.left, captain);
            else
                root.right = insert(root.right, captain);
        }
        return root;
    }

    // Finding node
    public CaptainNode findNode(int id) {
        return findNode(this.root, id);
    }
    private CaptainNode findNode(CaptainNode root, int id) {
        if (root == null)
            return null;
        else {
            if (id == root.getID())
                return root;
            else if (id < root.getID())
                return findNode(root.left, id);
            else
                return findNode(root.right, id);
        }
    }

    // Finding parent
    public CaptainNode parent(CaptainNode captain) {
        return parent(this.root, captain);
    }
    private CaptainNode parent(CaptainNode root, CaptainNode captain) {
        if (root == null || captain == root)
            return null;

        if (captain == root.left || captain == root.right)
            return root;

        if (captain.getID() < root.getID())
            return parent(root.left, captain);
        else if (captain.getID() > root.getID())
            return parent(root.right, captain);
        else
            return null;
    }

    // Finding if node is Leaf
    public  boolean isLeaf(CaptainNode root) {
        return (root.left == null && root.right == null);
    }

    // Finding if node has left child only
    public Boolean hasOnlyLeftChild(CaptainNode root) {
        return (root.left != null && root.right == null);
    }

    // Finding if node has right child only
    public Boolean hasOnlyRightChild(CaptainNode root) {
        return (root.left == null && root.right != null);
    }

    // finding smallest node
    public CaptainNode minNode(CaptainNode root) {
        if (root == null)
            return null;
        else if (root.left == null)
            return root;
        else
            return minNode(root.left);
    }

    // finding largest node
    public CaptainNode maxNode(CaptainNode root) {
        if (root == null)
            return null;
        else if (root.right == null)
            return root;
        else
            return maxNode(root.right);
    }

    // Deletion
    public  void delete(CaptainNode captain) {
        this.root = delete(this.root, captain);
    }
    private CaptainNode delete(CaptainNode root, CaptainNode captain) {
        CaptainNode node2delete, newNode2delete, parent, saveValue;

        node2delete = findNode(root, captain.getID());
        if (node2delete == null)
            return root;

        parent = parent(captain);

        if (isLeaf(node2delete)) {
            if (parent == null)
                return null;
            if (captain.getID() < parent.getID())
                parent.setLeft(null);
            else
                parent.setRight(null);
            return root;
        }

        if (hasOnlyLeftChild(node2delete)) {
            if (parent == null)
                return node2delete.left;
            if (captain.getID() < parent.getID())
                parent.setLeft(parent.left.left);
            else
                parent.setRight(parent.right.left);
            return root;
        }

        if (hasOnlyRightChild(node2delete)) {
            if (parent == null)
                return node2delete.right;
            if (captain.getID() < parent.getID())
                parent.setLeft(parent.left.right);
            else
                parent.setRight(parent.right.right);
            return root;
        }

        newNode2delete = minNode(node2delete.right); // or newNode2delete = maxNode(node2delete.left);
        saveValue = newNode2delete;
        root = delete(root, saveValue);
        node2delete.setID(saveValue.getID());
        node2delete.setName(saveValue.getName());
        node2delete.setAvailable(saveValue.isAvailable());
        node2delete.setRatingStars(saveValue.getRatingStars());
        return root;
    }
}
