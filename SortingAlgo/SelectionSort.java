package SortingAlgo;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Size: ");
         int size = input.nextInt();
         System.out.println("Elements:  ");
         int[] arr = new int[size];
         for(int i = 0;i<size;i++){
            arr[i] = input.nextInt();
         }
        input.close();
        selectionSort(arr);
        System.out.println("After sorting: ");
        printArray(arr);
    }
    public static void printArray(int[] arr){
        for(int e : arr){
            System.out.print(e+" ");
        }
        System.out.println();
    }
    public static void selectionSort(int[] arr){
        for(int i = 0;i<arr.length - 1;i++){
            
            int indexSmallest = i; 
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]< arr[indexSmallest]){
                    indexSmallest = j;
                }
            }
            swap(arr,i,indexSmallest);
            System.out.println(Arrays.toString(arr));
        }
    }
   public static void swap(int[] arr,int i,int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] =temp;
   } 
}
