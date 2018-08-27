package exams._2017_10_22_Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_RegularExtensions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        String line;
        while (!"Print".equals(line = reader.readLine())) {
            if (!line.contains("%")) {
                int start = text.indexOf(line);
                while (start >= 0) {
                    String replacement = new StringBuilder(line).reverse().toString();
                    text = text.replace(line, replacement);
                    start = text.indexOf(line, start + line.length());
                }
            } else {
                line = line.replaceAll("%", "\\\\S*");
                line = line.replaceAll("\\.", "\\\\.");
                Pattern pattern = Pattern.compile(line);
                Matcher matcher = pattern.matcher(text);

                while (matcher.find()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(matcher.group());
                    text = text.replace(sb.toString(), sb.reverse().toString());
                }
            }
        }

        System.out.println(text);
    }
}
