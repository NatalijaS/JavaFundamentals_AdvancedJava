package _01_IntroToJava_Exercises;

import java.util.Scanner;

public class _06_HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int target = scanner.nextInt();

        for (int i = 1; i <= 20 ; i++) {
            for (int j = 1; j <= 20; j++) {
                if(i + j == target) {
                    System.out.printf("%s + %s = %s\n", i, j, target);
                }
                if(i - j == target){
                    System.out.printf("%s - %s = %s\n", i, j, target);
                }
            }
        }
    }
}
