package _04_DataRepresentationAndManipulation_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _02_Searching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int num = Integer.parseInt(scanner.nextLine());
        binarySearch(num, arr);


    }
    public static void linearSearch(int num, int [] arr){
        boolean exists = false;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == num)     /* Searching element is present */
            {
                System.out.println(i);
                exists = true;
            }
        }

        if (!exists)  /* Searching element is absent */
            System.out.println(-1);
    }
    public static void binarySearch(int num , int [] arr){
        int firstIndex=0;
        int lastIndex=arr.length-1;
        int middleIndex=(firstIndex + lastIndex)/2;

        while(firstIndex <= lastIndex)
        {
            if(arr[middleIndex] < num)
            {
                firstIndex = middleIndex + 1;
            }
            else if ( arr[middleIndex] == num )
            {
                System.out.println(middleIndex);
                break;
            }
            else
            {
                lastIndex = middleIndex - 1;
            }
            middleIndex = (firstIndex + lastIndex)/2;

            if (firstIndex > lastIndex)
            {
                System.out.println(-1);
            }
        }
    }
}
