package exams._2018_06_10_Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _01_Internships {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int problemsCount = Integer.parseInt(reader.readLine());
        int candidatesCount = Integer.parseInt(reader.readLine());

        Deque<String> problems = new ArrayDeque<>();
        for (int i = 0; i < problemsCount; i++) {
            problems.push(reader.readLine());
        }

        Deque<String> candidates = new ArrayDeque<>();
        String validNameRegex = "[A-Z][a-z]+ [A-Z][a-z]+";
        for (int i = 0; i < candidatesCount; i++) {
            String name = reader.readLine();
            if (name.matches(validNameRegex)) {
                candidates.add(name);
            }
        }

        while (candidates.size() != 1 && problems.size() != 0) {
            if (calculatePoints(candidates.peek()) > calculatePoints(problems.peek())) {
                System.out.println(String.format("%s solved %s.", candidates.peek(), problems.pop()));
                candidates.add(candidates.poll());
            } else {
                System.out.println(String.format("%s failed %s.", candidates.poll(), problems.peek()));
                problems.add(problems.pop());
            }
        }
        if (candidates.size() == 1) {
            System.out.println(String.format("%s gets the job!", candidates.peek()));
        } else {
            System.out.println(String.join(", ", candidates));
        }
    }

    private static int calculatePoints(String peek) {
        int sum = 0;
        for (int i = 0; i < peek.length(); i++) {
            sum += peek.charAt(i);
        }
        return sum;
    }
}
