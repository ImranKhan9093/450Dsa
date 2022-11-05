/*
 You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the constraints that any painter will only paint contiguous sections of board.

2 painters cannot share a board to paint. That is to say, a board
cannot be painted partially by one painter, and partially by another.
A painter will only paint contiguous boards. Which means a
configuration where painter 1 paints board 1 and 3 but not 2 is
invalid.
Return the ans % 10000003

Input :
K : Number of painters
T : Time taken by painter to paint 1 unit of board
L : A List which will represent length of each board

Output:
     return minimum time to paint all boards % 10000003
Example

Input : 
  K : 2
  T : 5
  L : [1, 10]
Output : 50
Examples
Input : k = 2, A = {10, 10, 10, 10} 
Output : 20
Explanation: Here we can divide the boards into 2 equal sized partitions, so each painter gets 20 units of board and the total time taken is 20. 

Input : k = 2, A = {10, 20, 30, 40} 
Output : 60
Explanation: Here we can divide first 3 boards for one painter and the last board for second painter.


 */

package SearchingAndSorting;

public class PainterPartition {
    public static void main(String[] args) {
        int[] arr = {10, 10, 10, 10} ;
        int size = arr.length;
        int k = 2;
        System.out.println("The total time is:  " + minTimeToPaintBoards(arr, size, k));
    }

    public static int minTimeToPaintBoards(int[] arr, int size, int k) {
        int ans = -1;
        int start = arr[0];
        int end = sumOfArray(arr,size);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossibleSolution(arr, size, mid, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans % 10000003;
    }

    private static boolean isPossibleSolution(int[] arr, int size, int key, int k) {
        int totalTime = 0;
        int totalPainters = 1;
        for (int i = 0; i < size; i++) {
            totalTime += arr[i];

            if (totalTime > key) {
                totalPainters++;
                totalTime = arr[i];
            }
            if (totalPainters > k)
                return false;
        }
        return true;
    }
    private static int sumOfArray(int[] arr, int size){
        int sum =0;
        for (int i : arr) {
            sum+=i;
        }
        return sum;
    }
}
