package _01_IntroToJava_Lab;

import java.util.Scanner;

public class _06_NumbersFrom0To9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num=0;
        while(num < 10){
            System.out.printf("Number: %d\n", num);
            num++;
        }

    }
}
