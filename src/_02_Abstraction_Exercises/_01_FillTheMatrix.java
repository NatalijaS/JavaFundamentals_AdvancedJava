package _02_Abstraction_Exercises;

import java.util.Scanner;

public class _01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] line = scanner.nextLine().split(", ");

        int matrixHeight = Integer.parseInt(line[0]);
        String pattern = line[1];

        int [][] matrix = new int[matrixHeight][matrixHeight];

        if(pattern.equals("A")){
            matrix = methodA(matrixHeight);
        }else if (pattern.equals("B")){
            matrix = methodB(matrixHeight);
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }


    }

    private static int[][] methodB(int matrixHeight) {
        Scanner scanner = new Scanner(System.in);
        int currentNum = 1;
        int [][] matrix = new int [matrixHeight][matrixHeight];
        for (int col = 0; col < matrixHeight; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrixHeight; row++) {
                    matrix[row][col] = currentNum;
                    currentNum++;
                }
            }
            else
            {
                for (int row = matrixHeight - 1; row >= 0; row--)
                {
                    matrix[row][col] = currentNum;
                    currentNum++;
                }
            }
        }
        return matrix;
    }

    private static int[][] methodA(int matrixHeight) {
        Scanner scanner = new Scanner(System.in);
        int currentNum = 1;
        int [][] matrix = new int [matrixHeight][matrixHeight];
        for (int col = 0; col < matrixHeight; col++)
        {
            for (int row = 0; row < matrixHeight; row++)
            {
                matrix[row][col] = currentNum;
                currentNum++;
            }
        }
        return matrix;
    }
}
