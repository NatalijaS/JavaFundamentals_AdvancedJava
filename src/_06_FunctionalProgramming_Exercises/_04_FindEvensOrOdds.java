package _06_FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class _04_FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String [] input = reader.readLine().split(" ");

        int lowerBound = Integer.parseInt(input[0]);
        int upperBound = Integer.parseInt(input[1]);

        String command = reader.readLine();

        Predicate<Integer> findOddNumbers = x -> x % 2 != 0;
        Predicate<Integer> findEvenNumbers = x -> x % 2 == 0;

        List<Integer> result = new ArrayList<>();

        switch (command) {
            case "odd": findNumbers(result, findOddNumbers, lowerBound, upperBound); break;
            case "even": findNumbers(result, findEvenNumbers, lowerBound, upperBound); break;
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

    private static void findNumbers(List<Integer> result, Predicate<Integer> findTypeNumbers, int lowerBound, int upperBound) {
        for (int i = lowerBound; i <= upperBound; i++) {
            if (findTypeNumbers.test(i)) {
                result.add(i);
            }
        }
    }
}
