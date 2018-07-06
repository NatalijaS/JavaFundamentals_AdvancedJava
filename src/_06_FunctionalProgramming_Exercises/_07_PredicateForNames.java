package _06_FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class _07_PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String [] names = reader.readLine().split("\\s+");

        Predicate<String> check = str -> str.length() <= n;

        List<String> result = new ArrayList<>();
        for (String name : names) {
            if(check.test(name)){
                result.add(name);
            }
        }
        for (String s : result) {
            System.out.println(s);
        }
    }
}
