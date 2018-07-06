package _01_IntroToJava_Lab;

import java.util.Scanner;

public class _01_ReadInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.next("\\w+");
        String secondWord = scanner.next("\\w+");
        int firstInt = scanner.nextInt();
        int secondInt = scanner.nextInt();
        int thirdInt = scanner.nextInt();
        scanner.nextLine(); // Skip to the line end
        String thirdWord = scanner.nextLine();
        int sum =(int) (firstInt + secondInt + thirdInt);
        System.out.println(firstWord + " " + secondWord + " " + thirdWord + " " + sum);

    }
}
