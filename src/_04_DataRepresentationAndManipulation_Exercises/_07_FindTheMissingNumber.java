package _04_DataRepresentationAndManipulation_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _07_FindTheMissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(reader.readLine());
        int arr[] = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);


        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i + 1){
                System.out.println(i + 1);
                break;
            }else if(i == arr.length - 1){
                System.out.println(length);
            }

        }

    }
}
