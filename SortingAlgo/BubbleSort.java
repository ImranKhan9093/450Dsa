package SortingAlgo;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Size of array: ");
        int size = input.nextInt();
        System.out.println("Elements : ");
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        input.close();
       bubbleSort(arr);
       System.out.println("After sorting : ");
       printArray(arr);
    }
    public static void printArray(int[] arr){
        for(int e:arr){
            System.out.print(e+" ");
        }
    }
    public static void bubbleSort(int[] arr){
        for(int i = 1;i<arr.length;i++){
            boolean isSwapped = false;
            for(int j = 0;j<arr.length - i;j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                    isSwapped = true;
                }
            }
            if(isSwapped==false){
                return;
            }
        }
        System.out.println();
    }
    private static void swap(int[]arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
