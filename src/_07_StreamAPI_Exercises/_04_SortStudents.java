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
                .sorted((s1, s2) -> {
                    int comp = s1.lastName.compareTo(s2.lastName);
                    if (comp == 0) {
                        comp = s2.firstName.compareTo(s1.firstName);
                    }
                    return comp;
                })
                .forEach(s -> System.out.println(s.firstName + " " + s.lastName));
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
