package _01_IntroToJava_Exercises.BitwiseOperators;

import java.util.Scanner;

public class _02_ExtractBit3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int numRight = number >> 3;
        System.out.println(1 & numRight);
    }
}
