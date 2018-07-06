package _01_IntroToJava_Lab;

import java.util.Scanner;

public class _10_ModifyABit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int position = scanner.nextInt();
        int bitValue = scanner.nextInt();

        if(bitValue == 1){
            int mask = 1 << position;
            int result = num | mask;
            System.out.println(result);
        }else if(bitValue ==0){
            int mask = ~(1 << position);
            int result = num & mask;
            System.out.println(result);
        }
    }
}
