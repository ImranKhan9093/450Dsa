/*
 
Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).

His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
Input
t – the number of test cases, then t test cases follows.
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output
For each test case output one integer: the largest minimum distance.
Example
Input:

1
5 3
1
2
8
4
9
Output:

3
Output details:

FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
resulting in a minimum distance of 3.
 */

package SearchingAndSorting;

import java.util.Arrays;


public class AggressiveCows {
    public static void main(String[] args) {
        int[] arr = {4,2,3,1,6};
        int size = arr.length;
        int c = 2;
        System.out.println("The largest minimum distance is :"+findLargestMinimunDistance(arr,size,c));
    }
    public static int findLargestMinimunDistance(int[] arr,int size,int c){
        Arrays.sort(arr);
        int ans = -1;
        int start = arr[0];//min in array
        int end = arr[size - 1];//max in array

        while(start<=end){
            int mid = start + (end-start)/2;
            if(isPossibleSolution(arr,size,mid,c)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }
    private static boolean isPossibleSolution(int[] arr,int size ,int dist,int c){
        int distOfFirstCow = arr[0];
        int noOfCows = 1;
        for (int i = 0; i < size; i++) {
            int diff = arr[i] - distOfFirstCow;

            if(diff >=dist){
                noOfCows++;
                distOfFirstCow=arr[i];
            }

            if(noOfCows==c)
             return true;
        }
        return false;
    }

}
