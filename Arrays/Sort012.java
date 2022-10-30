/*
Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order withour sorting algorithm.


Example 1:

Input: 
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated 
into ascending order. */

package Arrays;

import java.util.Scanner;

public class Sort012 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array:  ");
        int size = input.nextInt();
        System.out.print("Enter the array elements:  ");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
    
        sort012(arr, size);
        System.out.print("The sorted array is ");
        printArray(arr);
        input.close();
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void sort012(int[] arr, int size) {
        // no sorting algo is allowed
        // Have  to use three pointer approach to swap elements
        System.out.println("ndjklgfhkdlfjghjklf");
        int start = 0;
        int mid = 0;
        int end = size - 1;
        while (mid <= end) {
            System.out.println("Start "+start+" Mid "+mid+" end" +end);
            if ( arr[mid] == 0) { 
                int temp = arr[mid];
                arr[mid] = arr[start];
                arr[start] = temp;
                start++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else { // arr[mid]==2 
                int temp = arr[end];
                arr[end] = arr[mid];
                arr[mid] = temp;
                end--;
            }
        }
    }
}
