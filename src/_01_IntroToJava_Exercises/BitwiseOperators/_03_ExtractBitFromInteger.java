package _01_IntroToJava_Exercises.BitwiseOperators;

import java.util.Scanner;

public class _03_ExtractBitFromInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int position = Integer.parseInt(scanner.nextLine());

        int numRight = num >> position;
        System.out.println(numRight & 1);
    }
}
