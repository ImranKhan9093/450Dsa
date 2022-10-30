package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
 
 Given an array A of size N, print the reverse of it.

Example:

Input:
1
4
1 2 3 4
Output:
4 3 2 1

 */


public class ReverseArray {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array:  ");
        int size = input.nextInt();
        System.out.print("Enter the array elements:  ");
        ArrayList<Integer> arr  = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(input.nextInt());
        }
        //calling funtion to reverser the array
        reverseArray(arr, size);
        System.out.println("The reversed array is: "+arr);
        input.close();
    }

    public static void reverseArray(ArrayList<Integer> arr,int size){
        int start = 0;
        int end = size - 1;

        while(start <= end){
            Collections.swap(arr, start, end);
            // int temp =arr.get(start);
            // arr.set(start, arr.get(end));
            // arr.set(end, temp);
            start++;
            end--;
        }

    }
    
}
