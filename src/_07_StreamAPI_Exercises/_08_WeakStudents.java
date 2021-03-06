package _07_StreamAPI_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _08_WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<StudentWithBadGrades, List<Integer>> students = new LinkedHashMap<>();

        String [] line = reader.readLine().split("\\s+");

        while(!"END".equals(line[0])){
            StudentWithBadGrades student = new StudentWithBadGrades(line[0], line[1]);

            students.putIfAbsent(student, new ArrayList<>());
            for (int i = 2; i < line.length ; i++) {
                students.get(student).add(Integer.parseInt(line[i]));
            }

            line = reader.readLine().split("\\s+");
        }

        students.entrySet().stream()
                .filter(kvp -> hasGrade(kvp.getValue()))
                .forEach(kvp-> System.out.println(kvp.getKey().firstName + " " + kvp.getKey().lastName));
    }

    private static boolean hasGrade(List<Integer> kvp) {
        List<Integer> grades = kvp.stream().filter(kvp1 -> kvp1 <= 3).collect(Collectors.toList());
        return grades.size() >= 2;
    }
}
class StudentWithBadGrades{

    String firstName;
    String lastName;

    StudentWithBadGrades(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
