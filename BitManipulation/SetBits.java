/*
 Given a positive integer N, print count of set bits in it. 

Example 1:

Input:
N = 6
Output:
2
Explanation:
Binary representation is '110' 
So the count of the set bit is 2.
Example 2:

Input:
8
Output:
1
Explanation:
Binary representation is '1000' 
So the count of the set bit is 1.
 */

package BitManipulation;

import java.util.Scanner;

public class SetBits {
    public static void main(String[] args){
        Scanner input  =new Scanner(System.in);
        System.out.print("Enter the number:  ");
        int n = input.nextInt();

       setBits(n);
      System.out.println("The number of set bits using Kernigham's algorithm is: "+setBitsCount(n));
        input.close();
    }

    //Tc O(N)
    public static void setBits(int n){
        int count = 0;
        while(n!=0){
            if((n&1) ==1)
             count++;
            n = n>>1;   
        }
        System.out.println("The total number set bits is: "+count);
    }

    
    //Kernighnam,s algorithm
    public static int setBitsCount(int n){
        int count = 0;
        while(n!=0){
            int rmsb = n & -n;
             count++;
            n = n - rmsb;
        }
        return count;
    }
}
