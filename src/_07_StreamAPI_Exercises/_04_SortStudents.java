package _07_StreamAPI_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _04_SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashSet<SortStudent> students = new HashSet<>();

        String[] line = reader.readLine().split("\\s+");
        while (!"END".equals(line[0])) {
            SortStudent student = new SortStudent(line[0], line[1]);
            students.add(student);
            line = reader.readLine().split("\\s+");
        }
        students.stream()
                .sorted((x1, x2) -> x2.firstName.compareTo(x1.firstName))
                .sorted((x1, x2) -> x1.lastName.compareTo(x2.lastName))
                .forEach(x -> System.out.println(x.firstName + " " + x.lastName));

    }
}

class SortStudent {
    String firstName;
    String lastName;

    SortStudent(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
