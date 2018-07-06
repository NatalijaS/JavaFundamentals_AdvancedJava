package _07_StreamAPI_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class _05_FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<StudentsWithMails, String> students = new LinkedHashMap<>();

        String[] line = reader.readLine().split("\\s+");
        while (!"END".equals(line[0])) {
            StudentsWithMails student = new StudentsWithMails(line[0], line[1]);
            students.putIfAbsent(student, line[2]);
            line = reader.readLine().split("\\s+");
        }
        students.entrySet()
                .stream()
                .filter(x -> x.getValue().endsWith("@gmail.com"))
                .forEach(x -> System.out.println(x.getKey().firstName + " " + x.getKey().lastName));
    }
}

class StudentsWithMails {
    String firstName;
    String lastName;

    StudentsWithMails(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
