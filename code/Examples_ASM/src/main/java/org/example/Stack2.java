package org.example;

// Define a Stack Interface
public interface Stack2<T> {
    void push(T item);      // Adds an item to the top of the stack
    T pop();                // Removes and returns the item from the top of the stack
    T peek();               // Returns the item at the top of the stack without removing it
    boolean isEmpty();      // Checks if the stack is empty
    boolean isFull();       // Checks if the stack is full (only applicable for array-based implementation)
}

