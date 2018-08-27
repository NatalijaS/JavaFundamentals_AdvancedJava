package _07_StreamAPI_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _07_MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        int limit = Integer.parseInt(reader.readLine());

        Map<String, List<Integer>> cities = new HashMap<>();

        for (String cityInfo : input) {
            String[] tokens = cityInfo.split(":");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);

            cities.putIfAbsent(city, new ArrayList<>());

            cities.get(city).add(population);
        }

        cities.entrySet().stream()
                .filter(getLargerThanPredicate(limit))
                .sorted(getSortedByDescendingComparator())
                .forEach(getPrintLargestFiveDistrictsConsumer());
    }

    private static Consumer<Map.Entry<String, List<Integer>>> getPrintLargestFiveDistrictsConsumer() {
        return e -> {
            System.out.print(e.getKey() + ": ");
            e.getValue().stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(5)
                    .forEach(d -> System.out.print(d + " "));
            System.out.println();
        };
    }

    private static Comparator<Map.Entry<String, List<Integer>>> getSortedByDescendingComparator() {
        return (c1, c2) -> Integer.compare(
                c2.getValue().stream().mapToInt(x -> x).sum(),
                c1.getValue().stream().mapToInt(Integer::valueOf).sum());
    }

    private static Predicate<Map.Entry<String, List<Integer>>> getLargerThanPredicate(int limit) {
        return c -> c.getValue().stream().mapToInt(x -> x).sum() >= limit;
    }
}
