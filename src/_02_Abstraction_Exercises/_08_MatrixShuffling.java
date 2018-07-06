package _02_Abstraction_Exercises;

import java.util.Objects;
import java.util.Scanner;

public class _08_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        String[][] matrix = new String[rows][columns];

        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < columns; col++)
            {
                matrix[row][col] = scanner.nextLine();
            }
        }

        String command = "";
        String[] input;
        while (!command.equals("END"))
        {
            input = scanner.nextLine().split(" ");
            if (input[0].equals("swap") && input.length == 5)
            {
                int row1 = Integer.parseInt(input[1]);
                int col1 = Integer.parseInt(input[2]);
                int row2 = Integer.parseInt(input[3]);
                int col2 = Integer.parseInt(input[4]);
                if (row1 > rows || col1 > columns || row2 > rows || col2 > columns)
                {
                    System.out.println("Invalid input!");
                }
                else
                {
                    System.out.printf("(after swapping %s and %s):", matrix[row1][col1], matrix[row2][col2]);
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;

                    PrintMatrix(matrix);
                }

            }
            else if (Objects.equals(input[0], "END"))
            {
                command = "END";
            }
            else
            {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void PrintMatrix(String[][] matrix)
    {
        for (int row = 0; row < matrix[0].length; row++)
        {
            for (int col = 0; col < matrix[1].length; col++)
            {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
