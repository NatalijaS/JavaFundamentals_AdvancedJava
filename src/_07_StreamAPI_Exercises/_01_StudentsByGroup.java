package _07_StreamAPI_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class _01_StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Student, Integer> students = new HashMap<>();

        String [] line = reader.readLine().split("\\s+");
        while (!"END".equals(line[0])){
            Student student = new Student(line[0], line[1]);
            students.putIfAbsent(student, 0);
            students.put(student, students.get(student) + Integer.valueOf(line[2]));

            line = reader.readLine().split("\\s+");
        }
        students.entrySet().stream().filter(kvp -> kvp.getValue() == 2)
                .sorted(Comparator.comparing(kvp -> kvp.getKey().firstName))
                .forEach(kvp -> System.out.println(kvp.getKey().firstName + " " + kvp.getKey().lastName));
    }
}
class Student{

   String firstName;
   String lastName;

    Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
