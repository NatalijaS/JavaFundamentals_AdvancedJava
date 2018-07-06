package exams.ExamPreparationI_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01_Schockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String [] rowsCols = reader.readLine().split(" ");
        int [][] matrix = new int [Integer.parseInt(rowsCols[0])][Integer.parseInt(rowsCols[1])];

        String command = reader.readLine();
        while(!command.equals("Here We Go")){
            String[] tokens = command.split(" ");
            int rowStart = Integer.parseInt(tokens[0]);
            int rowEnd = Integer.parseInt(tokens[2]);
            int colStart = Integer.parseInt(tokens[1]);
            int colEnd = Integer.parseInt(tokens[3]);
            for (int row = rowStart; row <= rowEnd; row++) {
                for (int col = colStart; col <= colEnd ; col++) {
                    matrix[row][col] += 1;
                }
            }
            command = reader.readLine();
        }
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
