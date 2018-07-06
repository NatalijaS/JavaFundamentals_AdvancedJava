package _03_StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Pattern;

public class _03_MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^\\+359( |-)2\\1\\d{3}\\1\\d{4}$";

        String number = scanner.nextLine();

        while (!"end".equals(number)) {
            if (Pattern.matches(regex, number)) {
                System.out.println(number);
            }

            number = scanner.nextLine();
        }
    }
}
