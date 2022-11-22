/*
 Given a row wise sorted matrix of size R*C where R and C are always odd, find the median of the matrix.

Example 1:

Input:
R = 3, C = 3
M = [
     [1, 3, 5], 
     [2, 6, 9], 
     [3, 6, 9]
    ]
Output: 5
Explanation: Sorting matrix elements gives 
us {1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
 

Example 2:

Input:
R = 3, C = 1
M = [[1], [2], [3]]
Output: 2
Explanation: Sorting matrix elements gives 
us {1,2,3}. Hence, 2 is median.
 */

package Matrix;

import java.util.ArrayList;
import java.util.Collections;

public class MedianInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5 },
                { 2, 6, 9 },
                { 3, 6, 9 }
        };
        System.out.println("The median is :" + median(matrix));
        System.out.println("The median using efficent method is: " + medianEfficent(matrix));

    }

    // this method uses extra space.
    public static int median(int[][] matrix) {
        int median = -1;
        ArrayList<Integer> sortedElements = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sortedElements.add(matrix[i][j]);
            }
        }
        Collections.sort(sortedElements);
        int medianIndex = (sortedElements.size() + 1) / 2;
        median = sortedElements.get(medianIndex - 1);
        return median;
    }

    // efficient approach
    // In case of odd elements the median is (1+N*M)/2 th smallest number which
    // basically implies that (1+N*M)/2 is the total number of elements which are
    // smaller or equal to our median.
    // the median will always lie in the range of minimum and maximum element.Using
    // these observations and applying binary search for elements in the above range
    // (minimum, maximum) and maintaing the counter for smaller or equal numbers for
    // each element in this range, we can find our median.
    public static int medianEfficent(int[][] matrix) {
        int median = -1;
        int row = matrix.length;
        int col = matrix[0].length;

        int min = matrix[0][0];
        int max = matrix[row - 1][col - 1];
        for (int i = 0; i < row ; i++) {
            if (matrix[i][0] < min)
                min = matrix[i][0];
            if (matrix[i][col - 1] > max)
                max = matrix[i][col - 1];
        }
        // count of elements smaller than median
        int start = min;
        int end = max;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // calculate number of elements smaller than mid in each row.If total is less than  equal
            // to (r*c)/2 then mid is a possible  median
            int elementsSmallerThanMid = 0;
            for (int i = 0; i < row; i++) {
                elementsSmallerThanMid += countSmallerThanMid(matrix[i], mid);
            }
            if(elementsSmallerThanMid <= ((row*col ) + 1)/2){
                median = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return median;
    }

    private static int countSmallerThanMid(int[] arr, int mid) {
        int start = 0;
        int end = arr.length - 1;
        int count = 0;
        while (start <= end) {
            int midd = start + (end - start) / 2;
            int element = arr[midd];
            if (element <= mid) {
                count = midd + 1; // midd gives the index ans as it is zero based indexing the count will be  mid + 1(atleast) 
                start = midd + 1;
            } else {
                end = midd - 1;
            }
        }

        return count;
    }
}
