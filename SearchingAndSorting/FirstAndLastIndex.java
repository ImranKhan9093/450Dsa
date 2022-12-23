/*
 Given a sorted array arr containing n elements with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.

Example 1:

Input:
n=9, x=5
arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
Output:  2 5
Explanation: First occurrence of 5 is at index 2 and last
             occurrence of 5 is at index 5. 
 

Example 2:

Input:
n=9, x=7
arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
Output:  6 6 

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function find() that takes array arr, integer n and integer x as parameters and returns the required answer.
Note: If the number x is not found in the array just return both index as -1.
 */

package SearchingAndSorting;

public class FirstAndLastIndex {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 5, 5, 5, 7, 123, 125 };
        int key = 5;
        int[] fl = firstAndLastIndex(arr, key);
        System.out.println("The first index is: " + fl[0] + " and the last index is: " + fl[1]);
        int fir = firstIndexRecursion(arr, 0, arr.length, key);
        if (fir == -1)
            System.out.println("Target not present");
        else
            System.out.println("The first index of element is " + fir);

        int lir = lastIndexRecursion(arr, 0, arr.length, key);
        if (lir == -1)
            System.out.println("Target not present");
        else
            System.out.println("The last index of element is " + lir);

    }

    public static int[] firstAndLastIndex(int[] arr, int key) {
        int[] fAndL = new int[2];

        int first = firstIndex(arr, key);
        int last = lastIndex(arr, key);
        fAndL[0] = first;
        fAndL[1] = last;

        return fAndL;
    }

    private static int firstIndex(int[] arr, int key) {
        int first = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                first = mid;
                end = mid - 1;

            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return first;
    }

    private static int lastIndex(int[] arr, int key) {
        int last = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                last = mid;
                start = mid + 1;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return last;
    }

    // Using recursion
    private static int firstIndexRecursion(int[] arr, int start, int end, int key) {
        // base case
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if (arr[mid] == key) {
            int fiisa = firstIndexRecursion(arr, start, mid - 1, key);
            if (fiisa != -1)
                return fiisa;
            else
                return mid;

        } else if (arr[mid] < key)
            return firstIndexRecursion(arr, mid + 1, end, key);
        else
            return firstIndexRecursion(arr, start, mid - 1, key);
    }

    private static int lastIndexRecursion(int[] arr, int start, int end, int key) {
        // base case
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;
        if (arr[mid] == key) {

            int lisa = lastIndexRecursion(arr, mid + 1, end, key);
            if (lisa != -1)
                return lastIndexRecursion(arr, mid + 1, end, key);
            else
                return mid;

        } else if (arr[mid] < key)
            return lastIndexRecursion(arr, mid + 1, end, key);
        else
            return lastIndexRecursion(arr, start, mid - 1, key);

    }
}
