package exams.ExamPreparationI_2018;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "(?<plusOrMinus>[,_])(?<letters>[a-zA-Z]+)(?<digit>\\d)";

        Map<String, String> decodedWords = new LinkedHashMap<>();
        String line = reader.readLine();
        while (!("Ascend").equals(line)) {
            for (Map.Entry<String, String> stringStringEntry : decodedWords.entrySet()) {
                line = line.replaceAll(stringStringEntry.getKey(), stringStringEntry.getValue());
            }

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                List<Character> values = new ArrayList<>();
                if (matcher.group("plusOrMinus").equals(",")) {
                    for (int i = 0; i < matcher.group("letters").length(); i++) {
                        values.add((char) (matcher.group("letters").charAt(i) + Integer.parseInt(matcher.group("digit"))));
                    }
                } else {

                    for (int i = 0; i < matcher.group("letters").length(); i++) {
                        values.add((char) (matcher.group("letters").charAt(i) - Integer.parseInt(matcher.group("digit"))));
                    }
                }
                StringBuilder value = new StringBuilder();
                value.append(values.toString().replaceAll("[\\[\\], ]", ""));
                decodedWords.putIfAbsent(matcher.group(0), value.toString());
                line = line.replaceAll(matcher.group(0), value.toString());
            }
            System.out.println(line);
            line = reader.readLine();
        }
    }
}
