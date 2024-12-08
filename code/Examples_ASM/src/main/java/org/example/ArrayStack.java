package org.example;

class ArrayStack<T> implements Stack<T> {
    private T[] stackArray;
    private int top;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public ArrayStack(int size) {
        this.maxSize = size;
        this.stackArray = (T[]) new Object[size];
        this.top = -1; // Stack is initially empty
    }
}

