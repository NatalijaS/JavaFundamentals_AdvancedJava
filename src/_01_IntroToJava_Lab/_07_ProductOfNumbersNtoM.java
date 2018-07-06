package _01_IntroToJava_Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class _07_ProductOfNumbersNtoM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int oldN=n;
        BigInteger product = BigInteger.ONE;
        do {
            BigInteger number = new BigInteger("" + n);
            product = product.multiply(number);
            n++;
        } while (n<= m);
        System.out.printf("product[%d..%d] = %d\n", oldN, m, product);
    }
}
