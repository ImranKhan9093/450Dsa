/*
 Given a boolean 2D array of n x m dimensions where each row is sorted. Find the 0-based index of the first row that has the maximum number of 1's.

Example 1:

Input: 
N = 4 , M = 4
Arr[][] = {
           {0, 1, 1, 1},
           {0, 0, 1, 1},
           {1, 1, 1, 1},
           {0, 0, 0, 0}
          }
Output: 2
Explanation: Row 2 contains 4 1's (0-based indexing).

Example 2:

Input: 
N = 2, M = 2
Arr[][] = {
           {0, 0}, 
           {1, 1}
          }
Output: 1
Explanation: Row 1 contains 2 1's (0-based indexing).
 */

package Matrix;

public class RowWithMax1 {
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}
        };
        int ans = maxRow1(matrix);
        if (ans == -1) {
            System.out.println("No such row");
        } else {
            System.out.println("Row is " + ans);
        }
    }
    //Nlogn 
    public static int maxRow1(int[][] matrix) {
        int maxRow1 = -1;
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        int lastElement = -1;
        for (int row = 0; row < nRow; row++) {
            lastElement = matrix[row][matrix[row].length - 1];
        }
        if (lastElement == -1)
            return -1;
        int rowTotal= 0;
        maxRow1 = 0;
        for (int row = 0; row < nRow; row++) {

            int total1 = 0;
            int firstIndex = firstIndex(matrix[row]);
            if (firstIndex != -1) {
                total1 += nCol  - firstIndex ;
            }
            
            if (total1 > rowTotal) {
                maxRow1 = row;
                rowTotal = total1;
            } 
        }

        return maxRow1;
    }

    private static int firstIndex(int[] arr) {
        int first = -1;

        int start = 0;
        int end = arr.length - 1;
        if (arr[end] != 1)
            return -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == 1) {
                first = mid;
                end = mid - 1;
            } else if(arr[mid] == 0){
                start = mid + 1;
            }
        }
        return first;
    }
}
