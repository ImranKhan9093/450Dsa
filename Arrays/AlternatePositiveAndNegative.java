/*
 Given an unsorted array Arr of N positive and negative numbers. Your task is to create an array of alternate positive and negative numbers without changing the relative order of positive and negative numbers.
Note: Array should start with a positive number.
 

Example 1:

Input: 
N = 9
Arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2}
Output:
9 -2 4 -1 5 -5 0 -3 2
Explanation : Positive elements : 9,4,5,0,2
Negative elements : -2,-1,-5,-3
As we need to maintain the relative order of
postive elements and negative elements we will pick
each element from the positive and negative and will
store them. If any of the positive and negative numbers
are completed. we will continue with the remaining signed
elements.The output is 9,-2,4,-1,5,-5,0,-3,2.

Example 2:

Input:
N = 10
Arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
Output:
5 -5 2 -2 4 -8 7 1 8 0
Explanation : Positive elements : 5,2,4,7,1,8,0
Negative elements : -5,-2,-8
As we need to maintain the relative order of
postive elements and negative elements we will pick
each element from the positive and negative and will
store them. If any of the positive and negative numbers
are completed. we will continue with the remaining signed
elements.The output is 5,-5,2,-2,4,-8,7,1,8,0.
 */

package Arrays;

import java.util.ArrayList;

public class AlternatePositiveAndNegative {
    public static void main(String[] args) {
        int[] arr = { 9, 4, -2, -1, 5, 0, -5, -3, 2 };
        rearrange(arr);

        System.out.println("The array after rearranging is:  ");
        printArray(arr);
    }


    //this method uses extra space of o(Max(posElements.size(),negElement.size()))
    public static void rearrange(int[] arr) {

        ArrayList<Integer> posElements = new ArrayList<>();
        ArrayList<Integer> negElements = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                posElements.add(arr[i]);

            } else {
                negElements.add(arr[i]);
            }
        }
        int j = 0;
        for (int i = 0; i < arr.length; i += 2) {
            if (j < posElements.size()) {
                arr[i] = posElements.get(j);
            }
            j++;
        }
        j = 0;
        for (int i = 1; i < arr.length; i += 2) {
            if (j < negElements.size()) {
                arr[i] = negElements.get(j);
            }
            j++;
        }

    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
