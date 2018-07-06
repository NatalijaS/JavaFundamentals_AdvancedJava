package _07_StreamAPI_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class _07_ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<StudentWithGrades, List<Integer>> students = new LinkedHashMap<>();

        String[] line = reader.readLine().split("\\s+");

        while (!"END".equals(line[0])) {
            StudentWithGrades student = new StudentWithGrades(line[0], line[1]);

            students.putIfAbsent(student, new ArrayList<>());
            for (int i = 2; i < line.length; i++) {
                students.get(student).add(Integer.parseInt(line[i]));
            }

            line = reader.readLine().split("\\s+");
        }

        students.entrySet().stream()
                .filter(x -> x.getValue().contains(6))
                .forEach(x -> System.out.println(x.getKey().firstName + " " + x.getKey().lastName));
    }
}

class StudentWithGrades {
    String firstName;
    String lastName;

    StudentWithGrades(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}