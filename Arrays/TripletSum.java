/*]
 Given an array arr of size n and an integer X. Find if there's a triplet in the array which sums up to the given integer X.


Example 1:

Input:
n = 6, X = 13
arr[] = [1 4 45 6 10 8]
Output:
{1, 4, 8}
Explanation:
The triplet {1, 4, 8} in 
the array sums up to 13.


Example 2:

Input:
n = 5, X = 10
arr[] = [1 2 4 3 6]
Output:
{1, 3, 6}
Explanation:
The triplet {1, 3, 6} in 
the array sums up to 10.
 */

package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class TripletSum {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 10, 8 };
        int sum = 13;
        System.out.println("The numbers are: " + tripletSum(arr, sum));

    }

    public static ArrayList<ArrayList<Integer>> tripletSum(int[] arr, int sum) {

        ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();
        int size = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < size; i++) {
            int start = i + 1;
            int end = size - 1;
            while (start < end) {
                int value = arr[i] + arr[start] + arr[end];
                if (value == sum) {

                    ArrayList<Integer> al = new ArrayList<>();
                    al.add(arr[i]);
                    al.add(arr[start]);
                    al.add(arr[end]);

                    triplets.add(al);
                    start++;
                    end--;
                } else if (value < sum) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return triplets;

    }

}
