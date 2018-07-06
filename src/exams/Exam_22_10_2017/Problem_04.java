package exams.Exam_22_10_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String [] input = reader.readLine().split(" ");

        String input2 = reader.readLine();
        while(!input2.equals("Print")){
            if(!input2.contains("%")){
                if(input2.contains(".")){
                    input2 = input2.replace(".",  "\\.");
                }
                String regex = input2;
                Pattern pattern = Pattern.compile(regex);
                for (int i = 0; i < input.length; i++) {
                    Matcher matcher = pattern.matcher(input[i]);
                    if(matcher.find()){
//                        input[i] = new StringBuilder(input[i]).reverse().toString();
                        String cs = input[i].substring(0, matcher.group().length());
                        StringBuilder sb = new StringBuilder(cs).reverse();
                        input[i] = input[i].replace(cs, sb);
                    }
                }
            }else {
                if(input2.contains(".")){
                    input2 = input2.replace(".",  "\\.");
                }
                input2 = input2.replaceAll("%", ".*");
                String regex = input2  ;
                Pattern pattern = Pattern.compile(regex);
                for (int i = 0; i < input.length; i++) {
                    Matcher matcher = pattern.matcher(input[i]);
                    if(matcher.find()){
                        String cs = input[i].substring(0, matcher.group().length());
                        StringBuilder sb = new StringBuilder(cs).reverse();
                        input[i] = input[i].replace(cs, sb);
                    }
                }
            }
            input2 = reader.readLine();
        }
        System.out.println(String.join(" ", input));
    }
}
