package _03_StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _11_ReplaceATag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("<a\\s+(href=[^>]+)>([^<]+)<\\/a>");

        StringBuilder sb = new StringBuilder("");

        String line = scanner.nextLine();

        while (!"END".equals(line)) {
            sb.append(line).append("\r\n");
            line = scanner.nextLine();
        }

        Matcher matcher = pattern.matcher(sb);

        int pos = 0;
        while (matcher.find(pos)) {
            int startMatch = matcher.start();
            int endMatch = matcher.end();
            String replacement= "[URL " + matcher.group(1) + "]" + matcher.group(2) + "[/URL]";
            sb.replace(startMatch, endMatch, replacement);

            matcher = pattern.matcher(sb);
        }

        System.out.println(sb);
    }
}
