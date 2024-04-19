/*
Name: Mahmued Ahmed Alardawi
ID: 2135209
Email: mmalardawi@stu.kau.edu.sa
Course: CPCS-204
Section: F1
Assignment: Binary Search Tree
Date: 11/2/2022
*/

import java.util.*;

public class CaptainNode {
    private int id;
    private String name;
    private int ratingStars = 0;
    private boolean available = true;
    public CaptainNode left;
    public CaptainNode right;

    // Constructor 1
    public CaptainNode () {}

    // Constructor 2
    public CaptainNode(int ID) {
        this.id = ID;
    }

    // Constructor 3
    public CaptainNode(int ID, String name) {
        this.id = ID;
        this.name = name;
    }

    // Constructor 4
    public CaptainNode(int ID, String name, CaptainNode left, CaptainNode right) {
        this.id = ID;
        this.name = name;
        this.left = left;
        this.right = right;
    }

    // Constructor 5
    public CaptainNode(int ID, String name, int ratingStars, boolean available, CaptainNode left,
                       CaptainNode right) {
        this.id = ID;
        this.name = name;
        this.ratingStars = ratingStars;
        this.available = available;
        this.left = left;
        this.right = right;
    }

    // Getters and setters
    public int getID() {
        return id;
    }
    public void setID(int ID) {
        this.id = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRatingStars() {
        return ratingStars;
    }
    public void setRatingStars(int ratingStars) {
        this.ratingStars = ratingStars;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public CaptainNode getLeft() {
        return left;
    }
    public void setLeft(CaptainNode left) {
        this.left = left;
    }
    public CaptainNode getRight() {
        return right;
    }
    public void setRight(CaptainNode right) {
        this.right = right;
    }

    // toString
    @Override
    public String toString() {
        return "CaptainNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ratingStars=" + ratingStars +
                ", available=" + available +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
