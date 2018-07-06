package _02_Abstraction_Exercises;

import java.util.Scanner;

public class _05_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] inp = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(inp[col]);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int[] start = new int[2];


        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum = 0;

                for (int row1 = row; row1 <= row + 2; row1++) {
                    for (int col1 = col; col1 <= col + 2; col1++) {
                        currentSum += matrix[row1][col1];
                    }
                }

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    start[0] = row;
                    start[1] = col;
                }
            }
        }


        System.out.println("Sum = " + maxSum);

        for (int row = start[0]; row <= start[0] + 2; row++) {
            for (int col = start[1]; col <= start[1] + 2; col++) {
                if (col == start[1] + 2) {
                    System.out.print(matrix[row][col]);
                } else {
                    System.out.print(matrix[row][col] + " ");
                }

            }
            System.out.println();
        }


//        for (int[] ints : matrix) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//
//            System.out.println();
//        }

    }
}
