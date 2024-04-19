/*
Name: Mahmued Ahmed Alardawi
ID: 2135209
Email: mmalardawi@stu.kau.edu.sa
Course: CPCS-204
Section: F1
Assignment: Binary Search Tree
Date: 11/2/2022
*/

import java.io.*;
import java.util.*;

public class MainProgram {
    public static void main(String [] args) throws FileNotFoundException {
        File file = new File("input.txt");
        PrintWriter output = new PrintWriter("output.txt");

        output.println("--------------- Welcome to Uber Booking System ---------------");

        UberTree uberTree = ADD_CAPTAIN(input(file), output);
        BOOK_RIDE(uberTree, input(file), output);
        DISPLAY_CAPTAIN_INFO(uberTree, input(file), output);
        FINISH_RIDE(uberTree, input(file), output);
        DELETE_CAPTAIN(uberTree, input(file), output);
        DISPLAY_ALL_CAPTAINS(uberTree, input(file), output);
        Quit(input(file), output);

        output.close();
    }

    public static Scanner input(File file) throws FileNotFoundException {
        return new Scanner(file);
    }

    public static UberTree ADD_CAPTAIN(Scanner input, PrintWriter output) {
        UberTree uberTree = new UberTree();

        while (input.hasNext()) {
            if (input.next().equals("Add_Captain")) {
                int id = input.nextInt();
                String name = input.next();

                CaptainNode captain = new CaptainNode(id, name);
                uberTree.insert(captain);

                output.println("Command Add_Captain: Add a new captain record in the System");
                output.println();
                output.println("\t\t\tID: " + id);
                output.println("\t\t\tName: " + name);
                output.println("\t\t\tAvailable: True");
                output.println("\t\t\tRating star: 0");
                output.println();
                output.println("----------------------------------------------------------------");
            }
        }
        return uberTree;
    }

    public static void BOOK_RIDE(UberTree uberTree, Scanner input, PrintWriter output) {
        while (input.hasNext()) {
            if (input.next().equals("BOOK_RIDE")) {
                int id = input.nextInt();

                if (uberTree.searchTree(id)) {
                    CaptainNode captain = uberTree.findNode(id);

                    if (captain.isAvailable()) {
                        captain.setAvailable(false);

                        output.println("Command BOOK_RIDE: Book a new Ride with captain " + id);
                    }
                    else {
                        output.println("Command BOOK_RIDE: The captain " + captain.getName() + " is not available." +
                                " He is on another ride!");
                        output.println();
                    }
                }
                else
                    output.println("Command BOOK_RIDE: Couldn't find any captain with ID number " + id);

                output.println();
                output.println("----------------------------------------------------------------");
            }
        }
    }

    public static void DISPLAY_CAPTAIN_INFO(UberTree uberTree, Scanner input, PrintWriter output) {
        while (input.hasNext()) {
            if (input.next().equals("DISPLAY_CAPTAIN_INFO")) {
                int id = input.nextInt();

                output.print("Command DISPLAY_CAPTAIN_INFO: ");
                if (uberTree.searchTree(id)) {
                    CaptainNode captain = uberTree.findNode(id);

                    output.println("\n\t\t\tID: " + captain.getID());
                    output.println("\t\t\tName: " + captain.getName());
                    output.println("\t\t\tAvailable: " + captain.isAvailable());
                    output.println("\t\t\tRating star: " + captain.getRatingStars());
                }
                else
                    output.println("Couldn't find any captain with ID number " + id);

                output.println();
                output.println("----------------------------------------------------------------");
            }
        }
    }

    public static void FINISH_RIDE(UberTree uberTree, Scanner input, PrintWriter output) {
        while (input.hasNext()) {
            if (input.next().equals("FINISH_RIDE")) {
                int id = input.nextInt();
                int ratingStar = input.nextInt();

                output.print("Command FINISH_RIDE: ");
                if (uberTree.searchTree(id)) {
                    CaptainNode captain = uberTree.findNode(id);

                    if (captain.isAvailable())
                        output.println("The captain " + captain.getName() + " is not in a ride!”");
                    else {
                        captain.setAvailable(true);
                        captain.setRatingStars(ratingStar);

                        output.println("Finish ride with captain " + captain.getID());
                        output.println("\n\t\t\tID: " + captain.getID());
                        output.println("\t\t\tName: " + captain.getName());
                        output.println("\t\t\tAvailable: " + captain.isAvailable());
                        output.println("\t\t\tRating star: " + captain.getRatingStars());
                    }
                }
                else
                    output.println("Couldn't find any captain with ID number " + id);

                output.println("----------------------------------------------------------------");
            }
        }
    }

    public static void DELETE_CAPTAIN(UberTree uberTree, Scanner input, PrintWriter output) {
        while (input.hasNext()) {
            if (input.next().equals("DELETE_CAPTAIN")) {
                int id = input.nextInt();

                output.print("Command  DELETE_CAPTAIN: ");
                if (uberTree.searchTree(id)) {
                    CaptainNode captain = uberTree.findNode(id);
                    uberTree.delete(captain);

                    output.println("The captain " + captain.getName() + " left Uber");
                }
                else
                    output.println("Couldn't find any captain with ID number " + id);

                output.println("----------------------------------------------------------------");
            }
        }
    }

    public static void DISPLAY_ALL_CAPTAINS(UberTree uberTree, Scanner input, PrintWriter output) {
        while (input.hasNext()) {
            if (input.next().equals("DISPLAY_ALL_CAPTAINS")) {
                output.println("Command DISPLAY_ALL_CAPTAINS: ");

                uberTree.preOrder(uberTree.getRoot(), output);
            }
        }
    }

    public static void Quit(Scanner input, PrintWriter output) {
        while (input.hasNext()) {
            if (input.next().equals("Quit")) {
                output.println("Thank you for using Uber System, Good Bye!");
            }
        }
    }
}