import java.util.Scanner;  


public class QuickSort {  
    private int[] arr;  

 
    public QuickSort() {  
        Scanner scanner = new Scanner(System.in);  
        System.out.print("Enter the number of elements: ");  
        int n = scanner.nextInt();  
        arr = new int[n];  
        System.out.println("Enter the elements:");  
        for (int i = 0; i < n; i++) {  
            arr[i] = scanner.nextInt();  
        }  
        scanner.close();  
    }  

    
    public void quickSort() {  
        quickSortRecursive(0, arr.length - 1);  
    }  

   
    private void quickSortRecursive(int low, int high) {  
        if (low < high) {  
            int pivotIndex = partition(low, high);  
            quickSortRecursive(low, pivotIndex - 1);  
            quickSortRecursive(pivotIndex + 1, high);  
        }  
    }  

    private int partition(int low, int high) {  
        int pivot = arr[high];  
        int i = low - 1;  
        for (int j = low; j < high; j++) {  
            if (arr[j] < pivot) {  
                i++;  
                swap(i, j);  
            }  
        }  
        swap(i + 1, high);  
        return i + 1;  
    }  

    private void swap(int i, int j) {  
        int temp = arr[i];  
        arr[i] = arr[j];  
        arr[j] = temp;  
    }  

  
    public void printArray() {  
        System.out.println("Sorted array:");  
        for (int num : arr) {  
            System.out.print(num + " ");  
        }  
        System.out.println();  
    }  
} 