package _01_IntroToJava_Lab;

import java.util.Scanner;

public class _02_AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = scanner.nextDouble();
        double secondNum = scanner.nextDouble();
        double thirdNum = scanner.nextDouble();

        double avr = (firstNum + secondNum + thirdNum)/3.0;

        System.out.printf("%.2f",avr);
    }
}
