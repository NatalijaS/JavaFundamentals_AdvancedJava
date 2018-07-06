package _01_IntroToJava_Exercises.BitwiseOperators;

import java.util.Scanner;

public class _05_ModifyBitAtGivenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int pos = Integer.parseInt(scanner.nextLine());
        int value = Integer.parseInt(scanner.nextLine());

       int numRight = num >> pos;
       int checkValue = numRight & 1;
       if(checkValue == value){
           System.out.println(num);
       }else{
           System.out.println(num ^ (1 << pos));
       }
    }
}
