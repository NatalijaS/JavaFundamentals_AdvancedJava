package _07_StreamAPI_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class _10_GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Person> people = new LinkedHashSet<>();

        String[] line = reader.readLine().split("\\s+");
        while (!"END".equals(line[0])) {
            Person person = new Person(line[0] + " " + line[1], Integer.parseInt(line[2]));
            people.add(person);
            line = reader.readLine().split("\\s+");
        }
        people.stream().collect(Collectors.groupingBy(p -> p.group, mapping((Person p) -> p.name, toList())))
                .forEach((x, y) -> {
                    System.out.print(x + " - ");
                    System.out.print(String.join(", ", y));
                    System.out.println();
                });
    }
}

class Person {
    String name;
    Integer group;

    Person(String name, Integer group) {
        this.name = name;
        this.group = group;
    }
}
