package _02_Abstraction_Exercises;

import java.util.Scanner;

public class _04_2x2SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] inputTokens = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = inputTokens[col];
            }
        }
        int counter = 0;
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                if(matrix[row][col].equals(matrix[row][col + 1]) && matrix[row][col].equals(matrix[row + 1][col]) &&
                        matrix[row][col].equals(matrix[row+1][col + 1])){
                    counter++;
                }
            }
        }

        System.out.println(counter);
    }
}
