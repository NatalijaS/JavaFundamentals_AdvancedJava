package _03_StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Pattern;

public class _09_MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";

        String name = scanner.nextLine();

        while (!"end".equals(name)) {

            if (Pattern.matches(regex, name)) {
                System.out.println(name);
            }

            name = scanner.nextLine();
        }
    }
}
