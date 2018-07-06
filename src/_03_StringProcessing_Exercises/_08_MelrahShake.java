package _03_StringProcessing_Exercises;

import java.util.Scanner;

public class _08_MelrahShake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());
        StringBuilder pattern = new StringBuilder(scanner.nextLine());

        while (true) {

            if (pattern.length() == 0) {
                System.out.println("No shake.");
                System.out.println(text);
                return;
            }

            int firstIndex = text.indexOf(pattern.toString());
            int lastIndex = text.lastIndexOf(pattern.toString());

            if (firstIndex == -1 || lastIndex == -1 || firstIndex == lastIndex) {
                System.out.println("No shake.");
                System.out.println(text);
                return;
            }

            text.delete(lastIndex, lastIndex + pattern.length());
            text.delete(firstIndex, firstIndex + pattern.length());

            System.out.println("Shaked it.");

            pattern.deleteCharAt(pattern.length() / 2);
           
        }
    }
}
