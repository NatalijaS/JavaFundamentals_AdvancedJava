package exams._2018_08_27_MyExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_Mission {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "(?<letters>[MISONCX]*)(?<values>[a-z]*)(?<digits>\\d*)";
        Pattern pattern = Pattern.compile(regex);

        Map<String, Integer> completedMissions = new HashMap<>();
        Map<String, Integer> failedMissions = new HashMap<>();

        String line;
        while (!"Decrypt".equals(line = reader.readLine())) {
            Matcher matcher = pattern.matcher(line);

            StringBuilder mission = new StringBuilder();
            StringBuilder values = new StringBuilder();
            StringBuilder letters = new StringBuilder();
            StringBuilder digits = new StringBuilder();

            while (matcher.find()) {
                letters.append(matcher.group("letters"));
                mission.append(matcher.group("letters").replaceAll("[^MISON]", ""));
                values.append(matcher.group("values"));
                digits.append(matcher.group("digits"));
            }
            if (mission.toString().contains("MISSION")) {
                int value = 0;

                for (int i = 0; i < digits.length(); i++) {
                    value += Integer.parseInt(String.valueOf(digits.charAt(i)));
                }

                if (letters.toString().contains("X")) {
                    failedMissions.put(values.toString(), value);
                } else {
                    completedMissions.put(values.toString(), value);
                }
            }
        }

        completedMissions.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(1).forEach(m ->
                System.out.println(String.format("Completed mission %s with rating: %d", m.getKey(), m.getValue())));

        failedMissions.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(1).forEach(m ->
                System.out.println(String.format("Failed Mission %s with rating: %d", m.getKey(), m.getValue())));
    }
}
