package _03_StringProcessing_Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _05_VowelCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("[aoieyuAOIEYU]");
        Matcher matcher = pattern.matcher(text);

        int counter = 0;

        while (matcher.find()) {
            counter++;
        }

        System.out.println("Vowels: " + counter);
    }
}
