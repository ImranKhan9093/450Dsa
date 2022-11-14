/*
 Given a matrix of size r*c. Traverse the matrix in spiral form.

Example 1:

Input:
r = 4, c = 4
matrix[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15,16}
             }
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
Explanation:

Example 2:

Input:
r = 3, c = 4  
matrix[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
             }
Output: 
1 2 3 4 8 12 11 10 9 5 6 7
Explanation:
Applying same technique as shown above, 
output for the 2nd testcase will be 
1 2 3 4 8 12 11 10 9 5 6 7.

 */

package Matrix;

import java.util.ArrayList;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        System.out.println("The spiral trversal is: " + spiralTraversal(matrix));
    }

    public static ArrayList<Integer> spiralTraversal(int[][] matrix) {
        ArrayList<Integer> spiral = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        int elementsAdded = 0;
        int totalElements = row * col;

        int leftWall = 0;
        int rightWall = col - 1;
        int topWall = 0;
        int bottomWall = row - 1;

        while (elementsAdded < totalElements) {

            // topWall
            for (int index = leftWall; index <= rightWall && elementsAdded < totalElements; index++) {

                spiral.add(matrix[leftWall][index]);
                elementsAdded++;
            }
            topWall++;


            // rightWall
            for (int index = topWall; index <= bottomWall && elementsAdded < totalElements; index++) {
                spiral.add(matrix[index][rightWall]);
                elementsAdded++;
            }
            rightWall--;


            // bottomWall
            for (int index = rightWall; index >= leftWall && elementsAdded < totalElements; index--) {
                spiral.add(matrix[bottomWall][index]);
                elementsAdded++;
            }
            bottomWall--;


            // leftWall
            for (int index = bottomWall; index >= topWall && elementsAdded < totalElements; index--) {
                spiral.add(matrix[index][leftWall]);
                elementsAdded++;
            }
            leftWall++;

        }

        return spiral;
    }
}
