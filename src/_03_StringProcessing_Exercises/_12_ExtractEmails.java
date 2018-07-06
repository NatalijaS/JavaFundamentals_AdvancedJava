package _03_StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12_ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(^| )(?<mail>[a-zA-Z0-9]+([-_.]*[a-zA-Z0-9]+)*@[a-zA-Z]+(-[a-zA-Z]+)*(\\.[a-zA-Z]+(-[a-zA-Z]+)*)+)(\\.|,| |$)";
        Pattern pattern = Pattern.compile(regex);
        String text = scanner.nextLine();

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group("mail"));
        }
    }
}
