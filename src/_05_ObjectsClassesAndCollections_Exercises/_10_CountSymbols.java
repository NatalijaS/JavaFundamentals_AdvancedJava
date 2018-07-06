package _05_ObjectsClassesAndCollections_Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _10_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> chars = new TreeMap<>();

        for (char c : text.toCharArray()) {
            if(!chars.containsKey(c)){
                chars.put(c, 1);
            }else{
                int charCount = chars.get(c);
                chars.put(c, ++charCount);
            }
        }

        for (Map.Entry<Character, Integer> charValue : chars.entrySet()) {
            System.out.println(charValue.getKey() + ": " + charValue.getValue() + " time/s");
        }
    }
}
