package _07_StreamAPI_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class _09_StudentsByEnrollmentYear {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> students = new LinkedHashMap<>();

        String [] line = reader.readLine().split("\\s+");
        while(!"END".equals(line[0])){
            students.putIfAbsent(line[0],new ArrayList<>());
            for (int i = 1; i < line.length ; i++) {
                students.get(line[0]).add(Integer.valueOf(line[i]));
            }

            line = reader.readLine().split("\\s+");
        }

        students.entrySet().stream()
                .filter(x -> x.getKey().endsWith("15") || x.getKey().endsWith("14"))
                .forEach(x -> {
                    for (Integer integer : x.getValue()) {
                        System.out.print(integer + " ");
                    }
                    System.out.println();
                });
    }
}
