package _03_StringProcessing_Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06_ExtractTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "<.+?>";

        Pattern pattern = Pattern.compile(regex);

        String line = scanner.nextLine();

        while (!"END".equals(line)) {
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }

            line = scanner.nextLine();
        }
    }
}
