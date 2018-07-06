package _06_FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _08_FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> findMinAndIndex = list -> {
          int min = Integer.MAX_VALUE;
          int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) <= min){
                    min = list.get(i);
                    index = i;
                }
            }
            return index;
        };

        int index = findMinAndIndex.apply(numbers);
        System.out.println(index);
    }
}
