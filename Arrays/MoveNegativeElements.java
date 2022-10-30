/*
Given an unsorted array arr[] of size N having both negative and positive integers. The task is place all negative element at the end of array without changing the order of positive element and negative element.

 

Example 1:

Input : 
N = 8
arr[] = {1, -1, 3, 2, -7, -5, 11, 6 }
Output : 
1  3  2  11  6  -1  -7  -5
 */
package Arrays;

import java.util.Arrays;

import java.util.Scanner;

public class MoveNegativeElements {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array:  ");
        int size = input.nextInt();
        System.out.print("Enter the array elements:  ");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i]=input.nextInt();
            
        }
        moveNegativeElements(arr,size);
        System.out.println("Array after moving elements : "+Arrays.toString(arr));
        input.close();
    }
    public static void moveNegativeElements(int[] arr ,int size){
        //since we have to preserve the order of the elements sorting cannot be used.
        // we can create a copy of the original  array and then  insert the elements in the original array while iterating over the copied array  based on the condiion of if current element is negative or not
        //in first loop we insert the positive elements in the order we encounter them in copied array and then copy the negative elements in the second loop
         int j = 0;
        int[] copy = Arrays.copyOf(arr, size);
        for (int i = 0; i < copy.length; i++) {
            if(copy[i]>0){
                arr[j] = copy[i];
                j++;
            }
        }
        for(int i = 0;i<copy.length;i++){
            if(copy[i]<0){
                arr[j] = copy[i];
                j++;
            }
        }
      
    }
}
