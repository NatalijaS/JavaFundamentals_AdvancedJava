package _07_StreamAPI_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class _02_StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String , Integer> students = new TreeMap<>();

        String [] line = reader.readLine().split("\\s+");
        while (!"END".equals(line[0])){
            students.putIfAbsent(line[0] + " " + line [1], 0);
            students.put(line[0] + " " + line [1], Integer.valueOf(line[2]));

            line = reader.readLine().split("\\s+");
        }
        students.entrySet().stream().filter(kvp -> kvp.getValue() == 2)
                .forEach(kvp -> System.out.println(kvp.getKey()));
    }
}
