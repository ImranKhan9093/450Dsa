/*
 Ninja and his friend are playing a game in which his friend selects an integer 'N'. He then picks 'N' random numbers and places them in an array/list ‘NUMARRAY’.
 Example 1: 
 Let ‘NUMARRAY’ = [-4, -2, 2, 5]. Here, only 'NUMARRAY[2]' = 2. So, our answer is 2.

 */

package SearchingAndSorting;



public class ElementEqualTIndex {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3 };
        System.out.println("The element equal to their indices are: " +valueEqualToIndices(arr));
    }

    public static int valueEqualToIndices(int[] arr) {
        
        int size = arr.length;

        int start = 0;
        int end = size - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] == mid) {

              return mid;
                
            } else if (arr[mid] < mid) {

                start = mid + 1;

            } else {

                end = mid - 1;
            }
        }
        

        return -1;
    }
}
