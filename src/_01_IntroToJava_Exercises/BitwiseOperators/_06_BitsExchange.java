package _01_IntroToJava_Exercises.BitwiseOperators;

import java.math.BigInteger;
import java.util.Scanner;

public class _06_BitsExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger num = new BigInteger(scanner.nextLine());

        BigInteger seven = new BigInteger("7");
        BigInteger _345 = num.shiftRight(3).and(seven);
        BigInteger _242526 = num.shiftRight(24).and(seven);

        num = ((num.and((seven.shiftLeft(24)).not())).or(_345.shiftLeft(24)));
        num = ((num.and(seven.shiftLeft(3).not())).or(_242526.shiftLeft(3))) ;
        System.out.println(num);
    }
}
