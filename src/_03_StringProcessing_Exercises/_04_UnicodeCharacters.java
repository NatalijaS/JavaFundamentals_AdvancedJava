package _03_StringProcessing_Exercises;

import java.util.Scanner;

public class _04_UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int codePoint = input.codePointAt(i);
            result.append("\\u").append(String.format("%04X", codePoint).toLowerCase());
        }

        System.out.println(result);
    }
}
