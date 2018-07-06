package _02_Abstraction_Exercises;

import java.util.Scanner;

public class _03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int [][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            String[] inputTokens = scanner.nextLine().split(" ");
            for (int column = 0; column < matrixSize; column++) {
                matrix[row][column] =
                        Integer.parseInt(inputTokens[column]);
            }
        }

        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;
        for (int i = 0; i < matrixSize; i++)
        {
            primaryDiagonal += (matrix[i][i]);
        }
        for (int i = 0; i < matrixSize; i++)
        {
            secondaryDiagonal += (matrix[i][matrix[i].length - 1 - i]);
        }
        System.out.println((Math.abs(primaryDiagonal - secondaryDiagonal)));
    }
}
