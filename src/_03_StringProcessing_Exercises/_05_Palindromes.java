package _03_StringProcessing_Exercises;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _05_Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("[ ,.?!]");

        Set<String> palindromes = new TreeSet<>();

        for (String word : words) {
            if (word.equals("")){
                continue;
            }

            boolean isPalindrome = true;

            for (int i = 0; i < word.length() / 2; i++) {
                if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                palindromes.add(word);
            }
        }

        System.out.println(palindromes);
    }
}
