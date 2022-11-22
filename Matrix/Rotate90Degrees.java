/*
  Given a square matrix, turn it by 90 degrees in a clockwise direction without using any extra space.

Examples: 

Input:
1 2 3 
4 5 6
7 8 9  
Output:
7 4 1 
8 5 2
9 6 3

Input:
1 2
3 4
Output:
3 1
4 2 
 */

package Matrix;

public class Rotate90Degrees {

  public static void main(String[] args) {
    int[][] matrix = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 }

    };
    int[][] rotatedMatrix = rotateMatrix(matrix);
    System.out.println("Matrix after rotation is:  ");
    printMatrix(rotatedMatrix);
    System.out.println("Rotate without extra space: ");
    rotateNoExtraSpace(matrix);
    printMatrix(matrix);
  }

  public static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      for (int ele : row) {
        System.out.print(ele + " ");
      }
      System.out.println();
    }
  }

  // This method uses extra space of O(N*N) and T.C O(N*N)
  public static int[][] rotateMatrix(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] temp = new int[row][col];
    int top = 0;
    int bottom = row - 1;
    int r = 0;
    int c = 0;
    int rowTemp = 0;
    int colTemp = 0;
    while (r < temp.length && c < temp[0].length) {

      for (int i = bottom; i >= top; i--) {
        temp[rowTemp][colTemp++] = matrix[i][c];

      }
      rowTemp++;
      colTemp = 0;
      r++;
      c++;
    }
    return temp;

  }

  public static void rotateNoExtraSpace(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    // for this we have to transpose the matrix then swap the row elements
    for (int i = 0; i < row; i++) {
      for (int j = i; j < col; j++) { // we start j from i instead from zero to avoid swapping the element from the
                                      // lower triangle twice.Starting j from i ensures we travel only in the upper
                                      // triangle
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    for (int i = 0; i < row; i++) {
      int start = 0;
      int end = col - 1;
      while (start <= end) {
        int temp = matrix[i][start];
        matrix[i][start] = matrix[i][end];
        matrix[i][end] = temp;
        start++;
        end--;
      }
    }
  }
}
