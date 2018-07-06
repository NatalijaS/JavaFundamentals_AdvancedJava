package _01_IntroToJava_Exercises;

import java.util.Scanner;

public class _07_CharacterMultiplier {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] str = scanner.nextLine().split(" ");

        String str1 = str[0];
        String str2 = str[1];

        long totalSum = 0L;

        if(str1.length() > str2.length()){
            String remainder = str1.substring(str2.length());
            for (int i = 0; i <remainder.length() ; i++) {
                totalSum += remainder.charAt(i);
            }
        }else if(str1.length() < str2.length()){
            String remainder = str2.substring(str1.length());
            for (int i = 0; i <remainder.length() ; i++) {
                totalSum += remainder.charAt(i);
            }
        }

        int shorterLength = Math.min(str1.length(), str2.length());

        for (int i = 0; i < shorterLength; i++) {
            totalSum += str1.charAt(i) * str2.charAt(i);
        }

        System.out.println(totalSum);
    }
}