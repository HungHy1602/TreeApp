/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treeapp;

/* Name: Le Cong Hung
Student Code: SE161248
Purpose: Problem TreeApp.
 */
import java.io.*;
import java.util.*;
import java.io.IOException;

class Main {

    public static void main(String[] args) throws IOException {
        int value;
        Tree theTree = new Tree();

        // Insert initial values
        theTree.insert(50, 1.5);
        theTree.insert(25, 1.2);
        theTree.insert(75, 1.7);
        theTree.insert(12, 1.5);
        theTree.insert(37, 1.2);
        theTree.insert(43, 1.7);
        theTree.insert(30, 1.5);
        theTree.insert(33, 1.2);
        theTree.insert(87, 1.7);
        theTree.insert(93, 1.5);
        theTree.insert(97, 1.5);

        while (true) {
            System.out.print("\nEnter first letter of show, ");
            System.out.print("insert, find, delete, traverse, clear, min, max, save, or quit: ");
            int choice = getChar();
            switch (choice) {
                case 's':
                    System.out.print("horizontal or vertical (1 or 2)? ");
                    value = getInt();
                    if (value == 1) {
                        System.out.println();
                        showTree(0, theTree.root);
                    } else {
                        theTree.displayTree();
                    }
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value, value + 0.9);
                    System.out.println("Comparisons = " + theTree.comps);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = theTree.find(value);
                    if (found != null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    } else {
                        System.out.print("Could not find ");
                        System.out.println(value);
                    }
                    System.out.println("Comparisons = " + theTree.comps);
                    break;
                case 'd':
                    System.out.print("Enter value to delete: ");
                    value = getInt();
                    boolean didDelete = theTree.delete(value);
                    if (didDelete) {
                        System.out.print("Deleted " + value + '\n');
                    } else {
                        System.out.print("Could not delete ");
                        System.out.println(value);
                    }
                    System.out.println("Comparisons = " + theTree.comps);
                    break;
                case 't':
                    System.out.print("Enter type 1, 2, or 3: ");
                    value = getInt();
                    theTree.traverse(value);
                    break;
                case 'c':
                    theTree.clearTree();
                    System.out.println("Tree cleared.");
                    break;
                case 'm':
                    Node minValue = theTree.findMin();
                    System.out.println("Minimum value: " + minValue);
                    break;

                case 'x':
                    Node maxValue = theTree.findMax();
                    System.out.println("Maximum value: " + maxValue);
                    break;

                case 'v':
                    ArrayList<Integer> itemList = new ArrayList<>();
                    theTree.saveInOrder(theTree.root, itemList);
                    System.out.println("Items saved in an array using in-order traversal.");
                    // Do something with the itemList, e.g., reinsert it into the tree
                    break;
                case 'q':
                    return;
                default:
                    System.out.print("Invalid entry\n");
            }  // end switch
        }  // end while
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    public static Node createNode(int data, Node l, Node r) {
        Node newNode = new Node();
        newNode.iData = data;
        newNode.leftChild = l;
        newNode.rightChild = r;
        return newNode;
    }

    public static void showTree(int n, Node t) {
        tab(n);
        if (t == null) {
            System.out.println("*");
        } else {
            n = n + 3;
            System.out.println(t.iData);
            if (t.leftChild == null && t.rightChild == null) {
                return;
            }
            showTree(n, t.leftChild);
            showTree(n, t.rightChild);
        }
    }

    public static void tab(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

} // end class Main
