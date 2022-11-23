/*
 You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).

Example 1:

Input: N = 4
Output: 5
Explanation:
For numbers from 1 to 4.
For 1: 0 0 1 = 1 set bits
For 2: 0 1 0 = 1 set bits
For 3: 0 1 1 = 2 set bits
For 4: 1 0 0 = 1 set bits
Therefore, the total set bits is 5.

Example 2:

Input: N = 17
Output: 35
Explanation: From numbers 1 to 17(both inclusive), 
the total number of set bits is 35.
 */
package BitManipulation;

import java.util.Scanner;

public class TotalSetBIts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number:  ");
        int n = input.nextInt();
        input.close();
        System.out.println("The total number of set bits is:  " + setBits(n));
    }
   //O(Nlogn)
    public static int setBits(int n) {
        int count = 1;
        for (int i = 2; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                int rmsb = temp & -temp;
                count++;
                temp = temp - rmsb;

            }
        }
        return count;
    }
}