package _01_IntroToJava_Exercises;

import java.util.Scanner;

public class _03_FormattingNumbers {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            int a = scanner.nextInt();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();

            System.out.print('|');
            System.out.print(String.format("%1$-10s", Integer.toHexString(a).toUpperCase()));
            System.out.print('|');
            System.out.print(String.format("%010d", Integer.parseInt(Integer.toBinaryString(a))));
            System.out.print('|');

            // This will always print trailing zeroes
            // This is intentional, because it is closer to the problem specified
            // even if the example seems wrong.
            System.out.print(String.format("%1$10s", String.format("%.2f", b)));
            System.out.print('|');
            System.out.print(String.format("%1$-10s", String.format("%.3f", c)));
            System.out.print('|');
            System.out.println();
        }
}
