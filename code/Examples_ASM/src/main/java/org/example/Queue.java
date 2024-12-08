package org.example;

public class Queue {
    public static void main(String[] args) {
        java.util.LinkedList<Integer> queue = new java.util.LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        int frontElement = queue.remove(); // Removes 10
        int peekElement = queue.peek(); // Shows 20

        System.out.println("Front element: " + frontElement);
        System.out.println("Peek element: " + peekElement);
    }
}
