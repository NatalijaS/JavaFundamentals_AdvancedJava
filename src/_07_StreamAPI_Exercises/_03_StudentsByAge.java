package _07_StreamAPI_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class _03_StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Students, Integer> students = new LinkedHashMap<>();

        String[] line = reader.readLine().split("\\s+");
        while (!"END".equals(line[0])) {
            Students student = new Students(line[0], line[1]);
            students.putIfAbsent(student, 0);
            students.put(student, Integer.valueOf(line[2]));

            line = reader.readLine().split("\\s+");
        }
        students.entrySet().stream().filter(kvp -> kvp.getValue() >= 18 && kvp.getValue() <= 24)
                .forEach(kvp -> System.out.printf("%s %d%n", kvp.getKey(), kvp.getValue()));
    }
}

class Students {
    String firstName;
    String lastName;

    Students(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}