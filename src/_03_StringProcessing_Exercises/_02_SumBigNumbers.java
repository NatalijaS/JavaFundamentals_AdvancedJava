package _03_StringProcessing_Exercises;

import java.util.Scanner;

public class _02_SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder firstNumber = new StringBuilder(scanner.nextLine());
        StringBuilder secondNumber = new StringBuilder(scanner.nextLine());

        StringBuilder result = new StringBuilder();
        int overflow = 0;

        removeZeros(firstNumber);
        removeZeros(secondNumber);

        firstNumber.reverse();
        secondNumber.reverse();


        if (secondNumber.length() > firstNumber.length()) {

            for (int i = 0; i < firstNumber.length(); i++) {
                int tempFirst = Integer.parseInt(firstNumber.substring(i, i + 1));
                int tempSecond = Integer.parseInt(secondNumber.substring(i, i + 1));
                int sum = tempFirst + tempSecond + overflow;

                if (sum > 9) {
                    overflow = 1;
                    sum -= 10;

                } else {
                    overflow = 0;
                }
                result.insert(0, sum);
            }

            for (int i = firstNumber.length(); i < secondNumber.length(); i++) {
                int tempSecond = Integer.parseInt(secondNumber.substring(i, i + 1));
                int sum = tempSecond + overflow;
                if (sum > 9) {
                    overflow = 1;
                    sum -= 10;

                } else {
                    overflow = 0;
                }
                result.insert(0, sum);
            }

            if (overflow > 0) {
                result.insert(0, overflow);
            }

        } else {
            for (int i = 0; i < secondNumber.length(); i++) {
                int tempFirst = Integer.parseInt(firstNumber.substring(i, i + 1));
                int tempSecond = Integer.parseInt(secondNumber.substring(i, i + 1));
                int sum = tempFirst + tempSecond + overflow;

                if (sum > 9) {
                    overflow = 1;
                    sum -= 10;
                } else {
                    overflow = 0;
                }
                result.insert(0, sum);
            }

            for (int i = secondNumber.length(); i < firstNumber.length(); i++) {
                int tempSecond = Integer.parseInt(firstNumber.substring(i, i + 1));
                int sum = tempSecond + overflow;
                if (sum > 9) {
                    overflow = 1;
                    sum -= 10;
                } else {
                    overflow = 0;
                }
                result.insert(0, sum);
            }

            if (overflow > 0) {
                result.insert(0, overflow);
            }
        }

        System.out.println(result);
    }

    private static void removeZeros(StringBuilder firstNumber) {
        while (firstNumber.charAt(0) == '0') {
            firstNumber.delete(0, 1);
        }
    }
}
