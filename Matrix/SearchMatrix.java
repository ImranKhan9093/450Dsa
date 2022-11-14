/*
 Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [
                    [1,3,5,7],
                    [10,11,16,20],
                    [23,30,34,60]
                ], 
    target = 3
Output: true


Example 2:


Input: matrix = [
                    [1,3,5,7],
                    [10,11,16,20],
                    [23,30,34,60]
                 ], 
                 
                 target = 13
Output: false
 
 */
package Matrix;

public class SearchMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        int target = 13;
        System.out.println(searchMatrix(matrix,target));
    }

public static boolean searchMatrix(int[][] matrix,int target){

    int row = matrix.length;
    int col = matrix[0].length;
    int start = 0;
    int end = row * col - 1;

    while(start<=end){

        int mid = start + (end - start)/2;
        int rowIndex = mid/col;
        int colIndex = mid % col;
        int element = matrix[rowIndex][colIndex];
        if(element == target)
             return true;
         else if(element < target)
             start = mid + 1;
         else 
             end  = mid - 1;
    }


    return false;
}

}