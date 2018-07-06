package _04_DataRepresentationAndManipulation_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _04_RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int sum = sumOfArray(arr, arr.length-1);
        System.out.println(sum);
    }
    public static int sumOfArray(int[] a, int n) {
        if (n == 0)
            return a[n];
        else
            return a[n] + sumOfArray(a, n-1);
    }
}
