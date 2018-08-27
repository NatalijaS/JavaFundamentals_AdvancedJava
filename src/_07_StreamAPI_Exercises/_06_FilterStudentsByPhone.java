package _07_StreamAPI_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class _06_FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<StudentByPhone, String> students = new LinkedHashMap<>();

        String[] line = reader.readLine().split("\\s+");
        while (!"END".equals(line[0])) {
            StudentByPhone student = new StudentByPhone(line[0], line[1]);
            students.putIfAbsent(student, line[2]);
            line = reader.readLine().split("\\s+");
        }
        students.entrySet()
                .stream()
                .filter(kvp -> kvp.getValue().startsWith("02") || kvp.getValue().startsWith("+3592"))
                .forEach(kvp -> System.out.println(kvp.getKey().firstName + " " + kvp.getKey().lastName));
    }
}

class StudentByPhone {
    String firstName;
    String lastName;

    StudentByPhone(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
