/*Given an array, rotate the array by one position in clock-wise direction.
 

Example 1:

Input:
N = 5
A[] = {1, 2, 3, 4, 5}
Output:
5 1 2 3 4 */

package Arrays;

import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array:  ");
        int size = input.nextInt();
        System.out.println("Enter the array elements : ");
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        System.out.print("Enter the value of k(the number of times to rotate):  ");
        int k = input.nextInt();
        input.close();
        int[] rotatedArray = rotateArray(arr, size, k);
        System.out.println("Array after rotating array is : ");
        printArray(rotatedArray, size);
        System.out.println();
        rotateArrayWithoutExtraSpace(arr, size, k);
        System.out.println("Rotated array without extra space ");
        printArray(arr, size);

    }

    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] rotateArray(int[] arr, int size, int k) {
        int[] rotatedArray = new int[size];
        k = k % size;
        for (int i = 0; i < size; i++) {
            rotatedArray[(i + k) % size] = arr[i];

        }
        return rotatedArray;
    }

    public static void rotateArrayWithoutExtraSpace(int[] arr, int size, int k) {
        // first we reverse the entire array
        // the then we rotate the from first element to k
        // then we rotate the array the array from k to the last element
        reverserArray(arr, size, 0, size - 1);
        reverserArray(arr, size, 0, k-1);
        reverserArray(arr, size, k , size - 1);

    }

    private static void reverserArray(int[] arr, int size, int start, int end) {
        while (start <= end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }
}
