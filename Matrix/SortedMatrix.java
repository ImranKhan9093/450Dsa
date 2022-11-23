/*
 You are given an N x N matrix 'MAT' of positive integers, where every row and column is sorted in non-decreasing order.

 If the matrix is:

{10,20,30,40},
{15,20,35,42},
{27,29,37,46},
{32,33,38,49}

The output will be the elements of matrix in sorted order:
10 15 20 20 27 29 30 32 33 35 37 38 40 42 46 49

 */

package Matrix;

import java.util.ArrayList;
import java.util.Collections;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 10, 20, 30, 40 },
                { 15, 20, 35, 42 },
                { 27, 29, 37, 46 },
                { 32, 33, 38, 49 }
              };
        System.out.println("Sorted order is: " + sortedMatrix(matrix));
    }
   // tc O(N^2 + NLogN) s.c = N^2
    public static ArrayList<Integer> sortedMatrix(int[][] matrix) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        
     
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sortedList.add(matrix[i][j]);
            }
        }
        Collections.sort(sortedList);
        return sortedList;
        
    }
}
