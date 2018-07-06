package _03_StringProcessing_Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        char[] firstWord = words[0].toCharArray();
        char[] secondWord = words[1].toCharArray();

        Map<Character, Character> magicWords = new HashMap<>();

        if (firstWord.length > secondWord.length) {
            for (int i = 0; i < secondWord.length; i++) {
                if (!magicWords.containsKey(firstWord[i])) {
                    if (!magicWords.containsValue(secondWord[i])) {
                        magicWords.put(firstWord[i], secondWord[i]);
                    } else {
                     System.out.println(false);
                        return;
                    }
                } else if (magicWords.get(firstWord[i]) != secondWord[i]) {
                    System.out.println(false);
                    return;
                }
            }

            for (int i = secondWord.length; i < firstWord.length; i++) {
                if (!magicWords.containsKey(firstWord[i])) {
                    System.out.println(false);
                    return;
                }
            }
        } else {
            for (int i = 0; i < firstWord.length; i++) {

                if (!magicWords.containsKey(firstWord[i])) {
                    if (!magicWords.containsValue(secondWord[i])) {
                        magicWords.put(firstWord[i], secondWord[i]);
                    } else {
                        System.out.println(false);
                        return;
                    }
                } else if (magicWords.get(firstWord[i]) != secondWord[i]) {
                    System.out.println(false);
                    return;
                }
            }

            for (int i = firstWord.length; i < secondWord.length; i++) {
                if (!magicWords.containsValue(secondWord[i])) {
                    System.out.println(false);
                    return;
                }

            }
        }
        System.out.println(true);
    }
}
