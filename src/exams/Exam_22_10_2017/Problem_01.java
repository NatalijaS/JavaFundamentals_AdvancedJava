package exams.Exam_22_10_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input [] = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();

       List<Integer> sum = new ArrayList<>();
       List<Integer> finalNumbers = new ArrayList<>();
       int finalNum = 0;
        for (int i = 0; i < input.length; i++) {
            sum.add(65535);

        }

        for (int i = 0; i <= input.length/2; i++) {
            int left = input[i];
            int currNum = input[i] & input[i +1];
            int nextNum = input[i +1] | left ;

            input[i] = currNum;
            input[i + 1] = nextNum;
        }

        System.out.println(Arrays.toString(input));

    }
}
