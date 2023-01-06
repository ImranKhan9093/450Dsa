package SortingAlgo;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Size :");
        int size = input.nextInt();
        System.out.println("Elements: ");
        int[] arr = new int[size];
        for(int i = 0;i<size;i++){
            arr[i] = input.nextInt();
        }

        input.close();
        insertionSort(arr);
        System.out.println("After sorting: ");
        printArray(arr);
    }

    public static void printArray(int[] arr){
        for(int e : arr){
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void insertionSort(int[] arr){
        for(int i = 1;i<arr.length;i++){
            int element = arr[i];
            int j = i - 1; 
            while(j>=0){
                if( arr[j] > element){
                  arr[j+1] = arr[j];
                }else{
                    break;
                }
                j--;
            }
            arr[j+1] = element;  
        }
    }
   
}
