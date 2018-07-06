package exams.JavaFundamentalsExam_19February2017;

import java.util.Scanner;

public class _01_Shockwave {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input1 = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input1[0]);
        int cols = Integer.parseInt(input1[1]);
        int [][] matrix = new int[rows][cols];

        String [] input2 = scanner.nextLine().split(" ");
        while(!"Here".equals(input2[0])){
            int row1 = Integer.parseInt(input2[0]);
            int col1 = Integer.parseInt(input2[1]);
            int row2 = Integer.parseInt(input2[2]);
            int col2 = Integer.parseInt(input2[3]);

            for (int i = row1; i <= row2 ; i++) {
                for (int j = col1; j <= col2 ; j++) {
                    matrix[i][j] += 1;
                }
            }

            input2 = scanner.nextLine().split(" ");
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
