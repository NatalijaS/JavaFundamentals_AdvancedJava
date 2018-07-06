package _01_IntroToJava_Lab;

import java.util.Scanner;

public class _09_ExtractABitFromInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int index = scanner.nextInt();

        int mask = num >> index;
        int bit = mask & 1;

        System.out.println(bit);
    }
}
