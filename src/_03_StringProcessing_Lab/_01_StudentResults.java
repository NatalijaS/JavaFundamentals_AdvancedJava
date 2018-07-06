package _03_StringProcessing_Lab;

import java.util.*;

public class _01_StudentResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" - ");
        String student = input[0];
        List<Double> examResults = new ArrayList<>();

        double sum = 0;

        String[] grades = input[1].split(", ");
        for (String grade : grades) {
            double token = Double.parseDouble(grade);
            examResults.add(token);
            sum += token;
        }

        examResults.add(sum / grades.length);

        System.out.println(String.format("%-10s|%7s|%7s|%7s|%7s|",
                "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));
            System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", student,
                    examResults.get(0),  examResults.get(1),  examResults.get(2),  examResults.get(3)));
    }
}
