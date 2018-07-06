package _02_Abstraction_Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class _06_PascalsTriangle {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int size = Integer.parseInt(console.nextLine());

        BigInteger[][] pascalTriangle = new BigInteger[size][size];
        for (int row = 0; row < size; row++) {
            pascalTriangle[row][0] = BigInteger.ONE;
            pascalTriangle[row][row] = BigInteger.ONE;

            if (row > 1) {
                for (int column = 1; column < row; column++) {
                    pascalTriangle[row][column] = pascalTriangle[row - 1][column - 1]
                            .add(pascalTriangle[row - 1][column]);
                }
            }

            for (int column = 0; column <= row; column++) {
                System.out.print(pascalTriangle[row][column] + " ");
            }
            System.out.println();
        }
    }
}
