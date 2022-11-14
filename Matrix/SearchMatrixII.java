/*
 You are given an N * N matrix of integers where each row and each column is sorted in increasing order. You are given a target integer 'X'. Find the position of 'X' in the matrix, if it exists then return the pair {i, j} where 'i' represents the row and 'j' represents the column of the array, otherwise return {-1,-1}
 example
input =  [ 
            [1, 2, 5],
            [3, 4, 9],
            [6, 7, 10]
         ] 
 We have to find the position of 4. We will return {1,1} since A[1][1] = 4.


 */

package Matrix;
class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}

public class SearchMatrixII {
    public static void main(String[] args){
       int[][] matrix = {
                                    {1, 2, 5},
                                    {3, 4, 9},
                                    {6, 7, 10}
                         };
        int target = 10;
        Pair p = findPair(matrix,target);
        System.out.println("The pair is {"+p.i+","+p.j+"}");

    }
    public static Pair findPair(int[][] matrix,int target){
        Pair p = new Pair(-1, -1);

        int row = matrix.length;
        int col = matrix[0].length;
        /*
             Array is sorted row wise,this means that any element  larger than the last element of the row then it cannot exist towards the left of that row.So we need to look in the next row.
             
             Array is sorted col wise,this means that any element  smaller than the first element of the column then it cannot exist in that column and we need to search in the previous column.
          
          
         */
        int rowIndex = 0;
        int colIndex = col - 1;
       
        while(rowIndex<row  && colIndex >=0){
           int element = matrix[rowIndex][colIndex];

           if(element  == target){
               p.i = rowIndex;
               p.j = colIndex;
               return p;
           }
             else if(element < target)
               rowIndex++;
              else
                colIndex--;

        }
        return p;


    }
}
