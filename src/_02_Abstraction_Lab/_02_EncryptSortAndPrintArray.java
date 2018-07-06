package _02_Abstraction_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _02_EncryptSortAndPrintArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] names = new String[n];
        int[] sums = new int[n];

        for (int i = 0; i < n; i++) {
            names[i] = scanner.nextLine();
            sums[i] = getHashResult(names[i]);
        }
        Arrays.sort(sums);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d%n", sums[i]);
        }
    }

    private static boolean isVowel(char a) {
        return "aeiouAEIOU".contains(String.valueOf(a));
    }

    private static int getHashResult(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isVowel(str.charAt(i))) {
                sum += (int) str.charAt(i) * str.length();
            } else {
                sum += (int) str.charAt(i) / str.length();
            }
        }
        return sum;
    }
}