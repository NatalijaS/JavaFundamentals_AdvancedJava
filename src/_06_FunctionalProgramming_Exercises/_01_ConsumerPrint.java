package _06_FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class _01_ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String [] input = reader.readLine().split("\\s+");
        Consumer<String> print = str -> System.out.println(str);

        for (String s : input) {
            print.accept(s);
        }
    }
}
