/*
 Given an array arr[] of distinct integers of size N and a value sum, the task is to find the count of triplets (i, j, k), having (i<j<k) with the sum of (arr[i] + arr[j] + arr[k]) smaller than the given value sum.


Example 1:


Input: N = 4, sum = 2
arr[] = {-2, 0, 1, 3}
Output:  2
Explanation: Below are triplets with 
sum less than 2 (-2, 0, 1) and (-2, 0, 3). 
 

Example 2:


Input: N = 5, sum = 12
arr[] = {5, 1, 3, 4, 7}
Output: 4
Explanation: Below are triplets with 
sum less than 12 (1, 3, 4), (1, 3, 5), 
(1, 3, 7) and (1, 4, 5).


Example  :  
If ‘N’ = 7, ‘ARR’ = { 1, 5, 2, 3, 4, 6, 7 } and ‘TARGET’ = 9

Then, there are three triplets with sum less than 9:
1) {1, 5, 2}
2) {1, 2, 3}
3) {1, 2, 4}
4) {1, 3, 4}

Thus, the output will be 4.
 */
package SearchingAndSorting;

import java.util.Arrays;

public class TripletWithLesserSum {
    public static void main(String[] args) {
        int[] arr ={ 1, 5, 2, 3, 4, 6, 7 };
        int size = arr.length;
        int sum = 9;
        System.out.println("The number of triplets :"+findTriplets(arr,size,sum));
    }
    public static int findTriplets(int[] arr,int size,int sum){
        Arrays.sort(arr);
      
        int countOfTriplets = 0;

        for (int i = 0; i<size - 2; i++) {
        int start = i;
        int mid = i + 1;
        int end = size - 1;  
        
        while(mid<end){
            int currSum = arr[start] + arr[mid] + arr[end];
            if(currSum<sum){ //if currSum for given indices is lower than sum then obviously any indices lower than the current indices will also give a lesser sum
                countOfTriplets+= (end - mid);
                mid++;
                  
            }else{
                end--;
                
            }
            
        }
        }

        return countOfTriplets;
    }
}