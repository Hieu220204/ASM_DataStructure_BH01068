package org.example;

public class Stack {
    public static void main(String[] args) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        int topElement = stack.pop(); // Removes 30
        int peekElement = stack.peek(); // Shows 20

        System.out.println("Top element: " + topElement);
        System.out.println("Peek element: " + peekElement);
    }
}
