package _04_DataRepresentationAndManipulation_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _05_Chocolates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int packetsCount = Integer.parseInt(reader.readLine());
        long[] arr = Arrays.stream(reader.readLine().split(", ")).mapToLong(Long::parseLong).toArray();
        int students = Integer.parseInt(reader.readLine());

        Arrays.sort(arr);
        long minDiff = findMinDiff(packetsCount, arr, students);

        System.out.println("Min Difference is " + minDiff + ".");
    }

    public static long findMinDiff(int packetsCount, long[] arr, int students) {
        long minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= packetsCount - students; i++) {
            long currentDiff = arr[i + students - 1] - arr[i];
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }
        }

        return minDiff;
    }
}
