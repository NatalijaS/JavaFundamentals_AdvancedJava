package _01_IntroToJava_Exercises;

import java.util.Scanner;

public class _01_RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        double arr = a * b;

        System.out.printf("%.2f", arr);
    }
}
