package Arrays;

import java.util.Scanner;

/*
Given an array A of size N of integers. Your task is to find the minimum and maximum elements in the array.

 

Example 1:

Input:
N = 6
A[] = {3, 2, 1, 56, 10000, 167}
Output:
min = 1, max =  10000 */
public class MaxMinInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size ");
        int size = input.nextInt();
        System.out.print("Enter the array elements:  ");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        int[] pair = getMinMax(arr, size);
        System.out.println("The minimun element is: " + pair[0] + " and the max element is: " + pair[1]);
        PairMinMax minMaxAPair = getMinAndMax(arr, size);
        System.out.println("Min of min-max pair is:  " + minMaxAPair.min + " and max is: " + minMaxAPair.max);
        input.close();
    }

    public static int[] getMinMax(int[] arr, int size) {
        int min = arr[0]; // let
        int max = arr[0];// let
        int[] minMaxPair = new int[2];
        if (size == 1) {
            min = arr[0];
            max = arr[0];
            minMaxPair[0] = min;
            minMaxPair[1] = max;
        } else if (size == 2) {
            if (arr[0] < arr[1]) {
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];

            }
            minMaxPair[0] = min;
            minMaxPair[1] = max;

        } else {
            System.out.println("Else block ");

            for (int i = 0; i < size; i++) {
              
                if (min > arr[i])
                    min = arr[i];
                

                if (max < arr[i])
                    max = arr[i];
                       

            }
            minMaxPair[0] = min;
            minMaxPair[1] = max;
        }
        return minMaxPair;
    }

    // using class to return multiple values
    static class PairMinMax {
        int min;
        int max;
    }

    public static PairMinMax getMinAndMax(int[] arr, int size) {
        PairMinMax pair = new PairMinMax();
        int min = arr[0];
        int max = arr[0];
        if (size == 1) {

            min = arr[0];
            max = arr[0];
            pair.min = min;
            pair.max = max;
        } else if (size == 2) {
            if (arr[0] < arr[1]) {
                min = arr[0];
                max = arr[1];

            } else {
                min = arr[1];
                max = arr[0];

            }
            pair.min = min;
            pair.max = max;
        } else {
            for (int i = 0; i < size; i++) {
                if (min > arr[i])
                    min = arr[i];
                if (max < arr[i])
                    max = arr[i];
            }
            pair.max = max;
            pair.min = min;
        }
        return pair;
    }

}
