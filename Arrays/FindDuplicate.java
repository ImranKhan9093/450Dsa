/*
 Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
 */

package Arrays;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr= {1,3,4,2,2};
        System.out.println("The duplicate is :"+findDuplicate(arr,arr.length));
        printDuplicates(arr,arr.length);
        
    }
  //code for when number is repeated only two times
    public static int findDuplicate(int[] arr,int size ){
        int ans = 0;
        for (int i = 0; i < size; i++) {
            ans = arr[i]^ans;            
        }
        for(int i = 1;i<size;i++){
            ans = ans^i;
        }
        return ans;
    }
    //modifies the original array
    public static void printDuplicates(int[] arr,int size){
        //since elements occur in the range 0 - n , the arry can itself be used to track and modifying element at the index
        //we find the index corresponfing to the value and increase it by n
        //we the divide each element by n.The result will be greater than 2  only if it has appeared more than once

        for (int i = 0; i < size; i++) {
            int index = arr[i]%size;
            arr[index]+=size;
        }
        for(int i = 0;i<size;i++){
            if((arr[i]/size)>=2)
             System.out.println(i+" ");
        }
    }
   }

