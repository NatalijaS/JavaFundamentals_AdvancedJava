package _03_StringProcessing_Lab;

import java.util.Scanner;

public class _03_ParseTags {
    private static final String UPCASE = "<upcase>";
    private static final String UPCASE_CLOSE = "</upcase>";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (input.contains(UPCASE)) {
            int indexOfUpcase = input.indexOf(UPCASE);
            int indexOfUpcaseClose = input.indexOf(UPCASE_CLOSE);

            String textSubstringed = input.substring(indexOfUpcase + UPCASE.length(), indexOfUpcaseClose);
            input = input.replace(UPCASE + textSubstringed + UPCASE_CLOSE, textSubstringed.toUpperCase());
        }

        System.out.println(input);
    }
}
