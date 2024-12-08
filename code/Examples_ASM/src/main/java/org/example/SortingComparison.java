package org.example;

public class SortingComparison {
    public static void main(String[] args) {
        int[] array1 = {9, 7, 5, 11, 12, 2, 14, 3, 10, 6};
        int[] array2 = array1.clone(); // Clone for a fair comparison

        System.out.println("Original Array:");
        printArray(array1);

        long startTime, endTime;

        // Quick Sort
        startTime = System.nanoTime();
        quickSort(array1, 0, array1.length - 1);
        endTime = System.nanoTime();
        System.out.println("Sorted with Quick Sort:");
        printArray(array1);
        System.out.println("Quick Sort Time: " + (endTime - startTime) + " ns");

        // Merge Sort
        startTime = System.nanoTime();
        mergeSort(array2, 0, array2.length - 1);
        endTime = System.nanoTime();
        System.out.println("Sorted with Merge Sort:");
        printArray(array2);
        System.out.println("Merge Sort Time: " + (endTime - startTime) + " ns");
    }

    // Quick Sort Implementation
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Merge Sort Implementation
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = array[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Utility to print the array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

