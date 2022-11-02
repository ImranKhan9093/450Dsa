/*
 You are given an array ‘ARR’ and another integer number ‘K’. Your task is to find the all elements of ‘ARR’ which occur more than or equals to ‘N/K’ times in ‘ARR’ and ‘N’ is the length of array ‘ARR’.
 

Example 1:

Given array ‘ARR = { 1, 2, 3, 3, 3, 3, 4, 4, 4, 1, 2 ,0}’ and ‘K = 4’
Answer is {3, 4} because ‘3’ occurs ‘4’ times and ‘4’ occurs ‘3’ times which is more than or equals to ‘12/ 4 =3’.
 */

package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementlll {
 public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 3, 3, 3, 4, 4, 4, 1, 2 ,0};
    int k = 4;
    System.out.println("All the numbers : " +majorityElement(arr,k));
 }   
 public static ArrayList<Integer> majorityElement(int[] arr ,int k){
    ArrayList<Integer> nums = new ArrayList<>();

    HashMap<Integer,Integer> countOfElements = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
        if(!countOfElements.containsKey(arr[i])){
            countOfElements.put(arr[i],1);
        }else{
            countOfElements.put(arr[i], countOfElements.get(arr[i]) + 1  );
        }
    }
    System.out.println(countOfElements);
    for(Map.Entry<Integer,Integer> en:countOfElements.entrySet()){
        int element = en.getKey();
        int count = en.getValue();
        if(count>= (arr.length)/k)
          nums.add(element);
    }
    return nums;
 }
}
