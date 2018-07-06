package _01_IntroToJava_Exercises.BitwiseOperators;

import java.util.Scanner;

public class _04_CheckBitAtGivenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int position = Integer.parseInt(scanner.nextLine());

        int numRight = num >> position;
        int mask = numRight & 1;
        if(mask == 1){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
