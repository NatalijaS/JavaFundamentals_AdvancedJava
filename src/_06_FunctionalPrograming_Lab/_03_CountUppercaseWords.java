package _06_FunctionalPrograming_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class _03_CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split(" ");

        Predicate<String> checkUpperCase = word -> word.charAt(0) == word.toUpperCase().charAt(0);

        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (checkUpperCase.test(word)) {
                result.add(word);
            }
        }

        System.out.println(result.size());
        for (String word : result) {
            System.out.println(word);
        }
    }
}
