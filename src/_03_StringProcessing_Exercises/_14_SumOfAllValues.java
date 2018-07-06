package _03_StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _14_SumOfAllValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String startKeyRegex = "^[A-Za-z_]+";
        String endKeyRegex = "[A-Za-z_]+$";

        Pattern startKeyPattern = Pattern.compile(startKeyRegex);
        Pattern endKeyPattern = Pattern.compile(endKeyRegex);

        String line = scanner.nextLine();
        String text = scanner.nextLine();

        Matcher startKeyMatcher = startKeyPattern.matcher(line);
        Matcher endKeyMatcher = endKeyPattern.matcher(line);
        if(!startKeyMatcher.find() || !endKeyMatcher.find()){
            System.out.println("<p>A key is missing</p>");
        }else{
            String textRegex = startKeyMatcher.group() + "\\d+\\.*\\d+" + endKeyMatcher.group() ;
            Pattern textPattern = Pattern.compile(textRegex);
            Matcher textMatch  = textPattern.matcher(text);
            double sum = 0.0;
            while(textMatch.find()){
                String match = textMatch.group();
                int start = startKeyMatcher.group().length();
                int end = endKeyMatcher.group().length();
                sum += Double.parseDouble(match.substring(start,match.length() - end));

            }
            if(sum == 0){
                System.out.println("<p>The total value is: <em>nothing</em></p>");
            }else{
                if((int)(sum) == sum){
                    System.out.printf("<p>The total value is: <em>%d</em></p>", (int)sum);
                }{
                    System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
                }
            }
        }

    }
}
