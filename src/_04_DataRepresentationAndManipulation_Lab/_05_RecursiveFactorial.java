package _04_DataRepresentationAndManipulation_Lab;

import java.util.Scanner;

public class _05_RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int fact = fact(n);
        System.out.println(fact);
    }
    public static int fact(int n) {
        if(n == 1){
            return 1;
        }
        return n*(fact(n-1)); // what happens if you switch the order?
    }
}
