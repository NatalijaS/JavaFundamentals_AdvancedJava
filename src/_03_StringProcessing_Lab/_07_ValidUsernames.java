package _03_StringProcessing_Lab;

import java.util.Scanner;
import java.util.regex.Pattern;

public class _07_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^[\\w-]{3,16}$";
        String username = scanner.nextLine();

        while (!"END".equals(username)) {
            if (Pattern.matches(regex, username)) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }

            username = scanner.nextLine();
        }
    }
}
