//package org.example;
//
//public class StudentQueueExample {
//    public static void main(String[] args) {
//        LinkedListQueue queue = new LinkedListQueue();
//
//        // Step 1: Enqueue Students 1, 2, and 3
//        queue.enqueue("Student1");
//        queue.enqueue("Student2");
//        queue.enqueue("Student3");
//
//        System.out.println("Queue state after Step 1: ");
//        queue.displayQueue(); // Displays: Student1 -> Student2 -> Student3
//
//        // Step 2: Dequeue Student1 (registration completed)
//        System.out.println("\nDequeued: " + queue.dequeue());
//
//        System.out.println("Queue state after Step 2: ");
//        queue.displayQueue(); // Displays: Student2 -> Student3
//
//        // Step 3: Enqueue Student4
//        queue.enqueue("Student4");
//
//        System.out.println("\nQueue state after Step 3: ");
//        queue.displayQueue(); // Displays: Student2 -> Student3 -> Student4
//    }
//}
//
//class LinkedListQueue {
//    private Node front, rear;
//
//    public LinkedListQueue() {
//        this.front = this.rear = null;
//    }
//
//    // Check if the queue is empty
//    public boolean isEmpty() {
//        return front == null;
//    }
//
//    // Add an item to the queue
//    public void enqueue(String item) {
//        Node newNode = new Node(item);
//        if (rear == null) {
//            front = rear = newNode;
//            return;
//        }
//        rear.next = newNode;
//        rear = newNode;
//    }
//
//    // Remove an item from the queue
//    public String dequeue() {
//        if (isEmpty()) {
//            return "Queue is empty";
//        }
//        String item = front.data;
//        front = front.next;
//        if (front == null) {
//            rear = null;
//        }
//        return item;
//    }
//
//    // Display the current state of the queue
//    public void displayQueue() {
//        if (isEmpty()) {
//            System.out.println("Queue is empty");
//            return;
//        }
//        Node temp = front;
//        while (temp != null) {
//            System.out.print(temp.data + (temp.next != null ? " -> " : ""));
//            temp = temp.next;
//        }
//        System.out.println();
//    }
//}
//
//class Node {
//    String data;
//    Node next;
//    Node(String data) {
//        this.data = data;
//        this.next = null;
//    }
//}
//
