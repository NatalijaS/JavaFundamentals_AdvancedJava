package _04_DataRepresentationAndManipulation_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _06_OverlappingIntervals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.valueOf(reader.readLine());

        int[][] matrix = new int[size][2];

        for (int i = 0; i < size; i++) {
            int[] current = Arrays.stream(reader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            matrix[i][0] = current[0];
            matrix[i][1] = current[1];
        }

        sortMatrix(matrix);
        System.out.println(checkOverlaping(matrix));

    }

    private static void sortMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i][0] > matrix[i + 1][0]) {

                int temp = matrix[i + 1][0];
                matrix[i + 1][0] = matrix[i][0];
                matrix[i][0] = temp;

                int temp1 = matrix[i + 1][1];
                matrix[i + 1][1] = matrix[i][1];
                matrix[i][1] = temp1;

            }
        }
    }

    private static boolean checkOverlaping(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i][1] >= matrix[i + 1][0]) {
                return true;
            }
        }
        return false;
    }
}
