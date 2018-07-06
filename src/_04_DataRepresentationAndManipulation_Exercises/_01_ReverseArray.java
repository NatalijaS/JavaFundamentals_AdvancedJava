package _04_DataRepresentationAndManipulation_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _01_ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arr[] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        reverseArr(arr, 0, arr.length - 1);
        printArr(arr);

    }
    public static void reverseArr(int [] arr, int startIndex, int endIndex){
       if(startIndex < endIndex){
           int tmp = arr[startIndex];
           arr[startIndex] = arr[endIndex];
           arr[endIndex] = tmp;
           reverseArr(arr, ++startIndex, --endIndex);//Recursive
       }else{
           return;
       }
    }
    public static void printArr(int [] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
