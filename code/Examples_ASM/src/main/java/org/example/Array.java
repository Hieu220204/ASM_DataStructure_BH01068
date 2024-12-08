package org.example;

public class Array {
    int[] array = {1, 2, 3, 4, 5};

    // Method to access an element
    public int accessElement(int index) {
        if (index >= 0 && index < array.length) {
            return array[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    // Method to update an element
    public void updateElement(int index, int value) {
        if (index >= 0 && index < array.length) {
            array[index] = value;
        } else {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    // Method to insert an element
    public void insertElement(int index, int value) {
        if (index < 0 || index > array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }

        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = value;
        System.arraycopy(array, index, newArray, index + 1, array.length - index);
        array = newArray; // Update the reference to the new array
    }

    // Method to print the array
    public void printArray() {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array arr = new Array();

        // Access element
        System.out.println("Access element at index 2: " + arr.accessElement(2));

        // Update element
        arr.updateElement(2, 10);
        System.out.print("Array after updating index 2 to 10: ");
        arr.printArray();

        // Insert element
        arr.insertElement(3, 20);
        System.out.print("Array after inserting 20 at index 3: ");
        arr.printArray();
    }
}
