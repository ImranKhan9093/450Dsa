package Strings;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string:  ");
        String s = input.next();
        System.out.println(isPalindrome(s)?"Palindrome":"Not palindrome");
        input.close();    
       
    }
    public static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
            if(s.charAt(end)!=s.charAt(start))
             return false;
            start++;
            end--; 
        }
        return true;
    }
}
