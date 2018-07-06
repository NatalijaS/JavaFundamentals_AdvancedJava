package _06_FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class _05_AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            numbers.add(Integer.valueOf(input[i]));
        }

        Function<List<Integer>, List<Integer>> add = list -> {
            List<Integer> result = new ArrayList<>();
            for (Integer integer : list) {
                integer += 1;
                result.add(integer);
            }
            return result;
        };
        Function<List<Integer>, List<Integer>> multiply = list -> {
            List<Integer> result = new ArrayList<>();

            for (Integer integer : list) {
                integer *= 2;
                result.add(integer);
            }
            return result;
        };
        Function<List<Integer>, List<Integer>> subtract = list -> {
            List<Integer> result = new ArrayList<>();
            for (Integer integer : list) {
                integer -= 1;
                result.add(integer);
            }
            return result;
        };
        Consumer<List<Integer>> print = list -> {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        };

        String command = reader.readLine();

        while (!"end".equals(command)) {
            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    break;
            }
            command = reader.readLine();
        }
    }
}
