package _02_Abstraction_Exercises;

import java.util.Scanner;

public class _07_CollectTheCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[4][];

        for (int i = 0; i < 4; i++) {
            board[i] = scanner.nextLine().toCharArray();
        }

        char[] move = scanner.nextLine().toCharArray();
        int row = 0;
        int col = 0;
        int coins = 0;
        int wallHits = 0;

        for (int i = 0; i < move.length; i++) {
            switch (move[i]) {
                case '<':
                    if (col - 1 < 0) {
                        wallHits++;
                        continue;
                    }
                    col -= 1;
                    break;
                case '>':
                    if (col + 1 >= board[row].length) {
                        wallHits++;
                        continue;
                    }
                    col += 1;
                    break;
                case '^':
                    if ((row - 1 < 0) || (col >= board[row - 1].length)) {
                        wallHits++;
                        continue;
                    }
                    row -= 1;
                    break;
                default:
                    if ((row + 1 > 3) || (col >= board[row + 1].length)) {
                        wallHits++;
                        continue;
                    }
                    row += 1;
                    break;
            }
            coins += (board[row][col] == '$') ? 1 : 0;
        }

        System.out.println("Coins = " + coins);
        System.out.println("Walls = " + wallHits);
    }
}
