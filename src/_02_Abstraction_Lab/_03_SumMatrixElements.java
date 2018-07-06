package _02_Abstraction_Lab;

import java.util.Scanner;

public class _03_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsCols = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] inputTokens = scanner.nextLine().split(", ");
            for (int column = 0; column < cols; column++) {
                matrix[row][column] =
                        Integer.parseInt(inputTokens[column]);
            }
        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        int sum = 0;
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//                sum += matrix[row][col];
//            }
//
//        }
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                sum += anAMatrix;
            }

        }
        System.out.println(sum);
    }
}
