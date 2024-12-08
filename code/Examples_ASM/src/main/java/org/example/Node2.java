package org.example;

class Node2<T> {
    T data;
    Node2<T> next;

    public Node2(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListStack<T> implements Stack<T> {
    private Node2<T> top;

    public LinkedListStack() {
        this.top = null; // Stack is initially empty
    }
}
