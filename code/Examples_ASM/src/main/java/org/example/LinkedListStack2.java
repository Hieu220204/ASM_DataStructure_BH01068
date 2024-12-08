package org.example;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListStack<T> implements Stack<T> {
    private Node<T> top;

    public LinkedListStack() {
        this.top = null; // Stack is initially empty
    }

    @Override
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top; // Point new node to the current top
        top = newNode;      // Update top to new node
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.data; // Get the data from the top node
        top = top.next;    // Update top to the next node
        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data; // Return the data from the top node
    }

    @Override
    public boolean isEmpty() {
        return top == null; // True if top is null
    }
}
