/*
 Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
Note: can you take care of the duplicates without using any additional Data Structure?

Example 1:

Input:
n1 = 6; A = {1, 5, 10, 20, 40, 80}
n2 = 5; B = {6, 7, 20, 80, 100}
n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20 80
Explanation: 20 and 80 are the only
common elements in A, B and C.
 */

package Arrays;

import java.util.ArrayList;

public class CommonElements {
    public static void main(String[] args) {
        int[] a = { 1, 5, 13, 20, 40, 80 };
        int[] b = { 6, 6, 20, 80, 100 };
        int[] c = { 3, 4,15, 20, 30, 70, 80,120 };

        System.out.println("The common elements are:  " + commonElements(a, b, c));

    }

    public static ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> common = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
             
            if (exists(a, c[i]) && exists(b, c[i])) {
                common.add(c[i]);
            }
            
        }

        return common;
    }

    private static boolean exists(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] < key) {
                start = mid + 1;

            } else {
                end = mid - 1;
            }

        }
        return false;
    }
}
