class ArrayStack2<T> implements Stack<T> {
    private T[] stackArray;
    private int top;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public ArrayStack2(int size) {
        this.maxSize = size;
        this.stackArray = (T[]) new Object[size];
        this.top = -1; // Stack is initially empty
    }

    @Override
    public void push(T item) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        stackArray[++top] = item; // Increment top and add the item
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top--]; // Return the top item and decrement top
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top]; // Return the top item without removing it
    }

    @Override
    public boolean isEmpty() {
        return top == -1; // True if top is -1
    }

    public boolean isFull() {
        return top == maxSize - 1; // True if top is at the maximum index
    }
}
