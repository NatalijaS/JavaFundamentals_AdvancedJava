package _03_StringProcessing_Lab;

import java.util.Scanner;

public class _04_SeriesOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();
        StringBuilder output = new StringBuilder();

        int state = 0;
        char prev = input[0];
        int i =0;
        while (i<input.length) {
            switch (state) {
                case 0: //Initial state
                    state = 1;
                    prev = input[i];
                    break;
                case 1: // Found a new letter
                    output.append(prev);
                    if (input[i] == prev)
                        state = 2;
                    prev = input[i];
                    break;
                case 2: // Found the same letter
                    if (input[i] != prev)
                        state = 1;
                    prev = input[i];
                    break;
            }
            ++i;
        }
        if (input[i - 2] != prev)
            output.append(prev);

            System.out.println(output.toString());
    }
}

