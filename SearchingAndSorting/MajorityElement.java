/*
 You have been given an array/list 'ARR' consisting of 'N' integers. Your task is to find the majority element in the array. If there is no majority element present, print -1.
 
 A majority element is an element that occurs more than floor('N' / 2) times in the array.
 Example 1:

Input:
N = 3 
A[] = {1,2,3} 
Output:
-1
Explanation:
Since, each element in 
{1,2,3} appears only once so there 
is no majority element.
Example 2:

Input:
N = 5 
A[] = {3,1,3,3,2} 
Output:
3
Explanation:
Since, 3 is present more
than N/2 times, so it is 
the majority element.

Your Task:
The task is to complete the function majorityElement() which returns the majority element in the array. If no majority exists, return -1.
 
 */

package SearchingAndSorting;

import java.util.Arrays;

public class MajorityElement {
 public static void main(String[] args) {
    int[] arr = {1,2,3};
    int size = arr.length;
    int majorityElement = majorityElement(arr, size);
    System.out.println(majorityElement!=-1?"The majoroty element is "+majorityElement:"No majority elements exists");
 }
 public static int majorityElement(int[] arr ,int size){
    Arrays.sort(arr);
    for (int i = 0; i < size; i++) {
        if(majorityExists(arr,size,arr[i])){
            return arr[i];
        }
    }
    return -1;
 }
 private static boolean majorityExists(int[] arr,int size , int key){
    int first = firstIndex(arr,size,key);
    int last = lastIndex(arr, size, key);
    int totalOccurance = last - first + 1;
    if(totalOccurance > Math.floor(size/2)){
        return true;
    }
    return false;
 }
 private static int firstIndex(int[] arr, int size,int key){
    int start = 0;
    int end = size - 1;
    int ans = -1;
    while(start<=end){
        int mid = start + (end -start)/2;
        if(arr[mid]==key){
            ans = mid;
            end = mid - 1;
        }else if(arr[mid]<key){
            start = mid+1;
        }else{
            end = mid  - 1;
        }
    }
    return ans;
 }
 private static int lastIndex(int[] arr, int size,int key){
    int start = 0;
    int end = size - 1;
    int ans = -1;
    while(start<=end){
        int mid = start + (end -start)/2;
        if(arr[mid]==key){
            ans = mid;
            start = mid +1;
        }else if(arr[mid]<key){
            start = mid+1;
        }else{
            end = mid  - 1;
        }
    }
    return ans;
 }
}
