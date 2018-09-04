package exams._2018_08_27_MyExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02_BombField {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int fieldSize = Integer.parseInt(reader.readLine());
        String[] commands = reader.readLine().split(",");

        String[][] field = new String[fieldSize][fieldSize];
        int positionRow = -1;
        int positionCol = -1;
        int bombCount = 0;
        for (int i = 0; i < fieldSize; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = tokens[j];
                if (tokens[j].equals("s")) {
                    positionRow = i;
                    positionCol = j;
                }
                if (tokens[j].equals("B")) {
                    bombCount++;
                }
            }
        }

        for (String command : commands) {
            if (bombCount <= 0) {
                break;
            }

            switch (command) {
                case "up":
                    positionRow = positionRow - 1;
                    if (positionRow < 0) {
                        positionRow = positionRow + 1;
                    }
                    break;
                case "down":
                    positionRow = positionRow + 1;
                    if (positionRow >= fieldSize) {
                        positionRow = positionRow - 1;
                    }
                    break;
                case "left":
                    positionCol = positionCol - 1;
                    if (positionCol < 0) {
                        positionCol = positionCol + 1;
                    }
                    break;
                case "right":
                    positionCol = positionCol + 1;
                    if (positionCol >= fieldSize) {
                        positionCol = positionCol - 1;
                    }
                    break;
            }

            if (field[positionRow][positionCol].equals("B")) {
                bombCount--;
                System.out.println("You found a bomb!");
                field[positionRow][positionCol] = "+";
            }
            if (field[positionRow][positionCol].equals("e")) {
                System.out.println(String.format("END! %d bombs left on the field", bombCount));
                return;
            }
        }
        if (bombCount == 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else {
            System.out.println(String.format("%d bombs left on the field. Sapper position: (%d,%d)"
                    , bombCount, positionRow, positionCol));
        }

    }
}
