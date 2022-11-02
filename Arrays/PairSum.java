/*
 You are given an array/list ‘ARR’ consisting of ‘N’ distinct integers arranged in ascending order. You are also given an integer ‘TARGET’. Your task is to count all the distinct pairs in ‘ARR’ such that their sum is equal to ‘TARGET’.


 
 1. Pair (x,y) and Pair(y,x) are considered as the same pair. 
 
 2. If there exists no such pair with sum equals to 'TARGET', then return -1.
 Example 1:
 Let ‘ARR’ = [1 2 3] and ‘TARGET’ = 4. Then, there exists only one pair in ‘ARR’ with a sum of 4 which is (1, 3). (1, 3) and (3, 1) are counted as only one pair.

 */

package Arrays;

import java.util.Arrays;
import java.util.HashSet;


public class PairSum {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 7, -1, 8 };
        int sum = 6;
        System.out.println("pair sum without sorting : "+pairSumWithoutSorting(arr,sum));
        System.out.println("the number of pairs with given sum is:  " +pairSum(arr, sum));
    }

    public static int pairSumWithoutSorting(int[] arr,int sum){
        int count = 0;
          HashSet<Integer> hs = new HashSet<>();
          for (int i = 0; i < arr.length; i++) {
            System.out.println(sum - arr[i]);
            if(!hs.contains(sum-arr[i]))
                hs.add(arr[i]);
            else
              count++;
          }
        //this method does not count unique pairs
        //if element are repeated at different indices then count will be increamented even if sum -arr[i] has already been encountered
        //returning the size is better as only sum -arr[i](unique)  so the elements in hashset when susbracted with sum will be presen in arr.hence the size is the number of pairs.
        return count>0?count:-1;
    }
    public static int pairSum(int[] arr, int sum) {
        int count = 0;
        int start = 0;
        int end = arr.length - 1;
        Arrays.sort(arr);
        while (start <=end) {
            if ((arr[start] + arr[end]) == sum) {
                count++;
                start++;
                end--;
            } else if ((arr[start] + arr[end]) < sum) {
                start++;
            } else {
                end--;
            }
            if((start == end) &&(arr[start]+arr[end] == sum))
                count--;
            
        }
        return count>0?count:-1;
    }
}