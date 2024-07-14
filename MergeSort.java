import java.util.Scanner;

public class MergeSort {
    private int[] arr;

    public MergeSort() {
        // Get user input for the array
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        arr = new int[size];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    public void run() {
        mergeSort();
        printSortedArray();
    }

    private void mergeSort() {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = new int[mid];
            int[] right = new int[arr.length - mid];

            // Divide the array into two halves
            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
            }
            for (int i = mid; i < arr.length; i++) {
                right[i - mid] = arr[i];
            }

            // Recursively sort the two halves
            MergeSort leftSort = new MergeSort(left);
            leftSort.mergeSort();
            MergeSort rightSort = new MergeSort(right);
            rightSort.mergeSort();

            // Merge the sorted halves
            merge(leftSort.arr, rightSort.arr);
        }
    }

    private void merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the two sorted halves
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Add any remaining elements from the left or right half
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    private MergeSort(int[] arr) {
        this.arr = arr;
    }

    private void printSortedArray() {
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

      
    
}