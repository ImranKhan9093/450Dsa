/*
 Ninja has been given two sorted integer arrays/lists ‘ARR1’ and ‘ARR2’ of size ‘M’ and ‘N’. Ninja has to merge these sorted arrays/lists into ‘ARR1’ as one sorted array. You may have to assume that ‘ARR1’ has a size equal to ‘M’ + ‘N’ such that ‘ARR1’ has enough space to add all the elements of ‘ARR2’ in ‘ARR1’.
 Exmaple 
 ‘ARR1’ = [3 6 9 0 0]
‘ARR2’ = [4 10]
After merging the ‘ARR1’ and ‘ARR2’ in ‘ARR1’. 
‘ARR1’ = [3 4 6 9 10]
 */

package SearchingAndSorting;


public class MergeTwoSortedArrays {
  public static void main(String[] args) {
    int[] arr1 = {3,6,9,0,0};
    int[] arr2 = {4,10};
    merge(arr1,arr2);
    System.out.println("Array 1 after merging is: ");
    printArray(arr1);
  }   
  public static void printArray(int[ ] arr){
    for (int i : arr) {
        System.out.print(i+"  ");
    }
  }
  public static void merge(int[] arr1,int[]arr2){

      int i = arr1.length - arr2.length - 1;
      int j = arr2.length - 1 ;
      int k = arr1.length - 1 ;
    while(j>=0){
        if(i>=0 && arr1[i]>arr2[j]){
            System.out.print(arr1[i]);
            arr1[k] = arr1[i];
            i--;
        }else{
            arr1[k] = arr2[j];
            j--;
        }
        k--;
    }

    
     
  }
}
