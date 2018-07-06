package _04_DataRepresentationAndManipulation_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _03_BinarySearchRecursive {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int arr[] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = scanner.nextInt();
        binarySearch(arr, n, 0, arr.length-1);
        System.out.println(binarySearch(arr, n, 0, arr.length-1));

    }

    static int binarySearch(int arr[], int key, int start, int end) {
        if (end < start)
            return -1;
        else {
            int mid = (start + end) / 2;
            if (arr[mid] > key)
                return binarySearch(arr, key, start, mid - 1);
            else if (arr[mid] < key)
                return binarySearch(arr, key, mid + 1, end);
            else
                return mid;
        }
    }

    private static void printArr(int[] arr) {

        System.out.print("{ ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + " }");
        System.out.println();
    }
}
