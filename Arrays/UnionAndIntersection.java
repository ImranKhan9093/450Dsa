/*Given two arrays a[] and b[] of size n and m respectively. The task is to find union between these two arrays.

Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in the union.

Example 1:

Input:
5 3
1 2 3 4 5
1 2 3
Output: 
5
Explanation: 
1, 2, 3, 4 and 5 are the
elements which comes in the union set
of both arrays. So count is 5.
 */
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersection {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int n = a.length;
        int[] b = { 1, 2, 3 };
        int m = b.length;

        System.out.println("The union count is: " + unionArray(a, n, b, m));
        System.out.println("The union count without extra space  is: " + countUnionNoExtraSpace(a, n, b, m));
        int[] arr1 ={4,3,8,2};
        int[] arr2 = {4,5,2,9,6};
        
        System.out.println("The intersection of arrays without sorting is:  "+intersectionWIthoutSorting(arr1, arr2));
        System.out.println("The intersection of arrays is:  "+intersection(arr1, arr1.length, arr2, arr2.length));
    }

    public static int unionArray(int[] a, int n, int[] b, int m) {
        // set data structure can be used to used elements from both arrays(set cannot
        // have dupliucate elements so we can easily find the count after union)
        Set<Integer> union = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!union.contains(a[i])) {
                union.add(a[i]);
            }
        }

        for (int i = 0; i < m; i++) {
            if (!union.contains(b[i])) {
                union.add(b[i]);
            }
        }
        return union.size();
    }

    public static int countUnionNoExtraSpace(int[] a, int n, int[] b, int m) {
        int greaterSize = n > m ? n : m;
        int count = 0;
        int i = 0, j = 0;
        if (a[n - 1] < b[0])
            count = n+m;
        else if (a[0] > b[m - 1])
            count = n+m;
        else {
            while (i < n && j < m) {
                if (a[i] == b[j]) {
                    count++;
                    i++;
                    j++;
                } 
            }
            while(i<greaterSize || j<greaterSize){
                
                count++;
                i++;
                j++;

            }
        }

        return count;
    }
    public static ArrayList<Integer> intersection(int[] a,int n ,int[] b, int m){
        ArrayList<Integer> intersertion = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int i =0;
        int j =0;
        while(i<n && j<m){
            if(a[i] == b[j]){
                intersertion.add(a[i]);
                i++;
                j++;
            }else if(a[i]<b[j]){
                i++;
            }else{
                j++;
            }
        }
      return intersertion;        

    }
    public static ArrayList<Integer> intersectionWIthoutSorting(int[] a, int[] b){
        ArrayList<Integer> intersection = new ArrayList<>();
        HashSet<Integer> common = new HashSet<>();
         for (int i = 0; i < a.length; i++) {
            common.add(a[i]);
         }
         for (int i = 0; i < b.length; i++) {
            if(common.contains(b[i])){
                intersection.add(b[i]);
            }
            
         }
         return intersection;
    }

}
