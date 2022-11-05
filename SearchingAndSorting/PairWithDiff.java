/*
 Given an array Arr[] of size L and a number N, you need to write a program to find if there exists a pair of elements in the array whose difference is N.

Example 1:

Input:
L = 6, N = 78
arr[] = {5, 20, 3, 2, 5, 80}
Output: 1
Explanation: (2, 80) have difference of 78.
Example 2:

Input:
L = 5, N = 45
arr[] = {90, 70, 20, 80, 50}
Output: -1
Explanation: There is no pair with difference of 45.
 */

package SearchingAndSorting;

import java.util.Arrays;

public class PairWithDiff {
    public static void main(String[] args) {
        int[] arr = {5, 20, 3, 2, 5, 80};
        int size = arr.length;
        int diff = 78;
        System.out.println("Does pair exist?  "+findPair(arr,size,diff));
    }
    public static String findPair(int[] arr ,int size ,int k){
        Arrays.sort(arr);
       
     int low= 0;
     int high = 1;
     k = Math.abs(k);
     while(low<size && high < size){
        int diff =  arr[high] - arr[low];
        if( low!=high && (diff == k  )){
            return "yes";
        }else if(diff>k){
            low++;
        }else{
            high++;
        }
     }
     return "NO";
    }
    

}
