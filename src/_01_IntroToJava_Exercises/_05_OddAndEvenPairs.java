package _01_IntroToJava_Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _05_OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String [] numbersString = line.split(" ");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numbersString.length ; i++) {
            numbers.add(Integer.parseInt(numbersString[i]));
        }

        boolean isThePairEven = false;
        boolean isThePairOdd = false;

        for (int i = 0; i < numbers.size() ; i+=2) {
            isThePairEven = false;
            isThePairOdd = false;
            if(numbers.size() % 2 == 1){
                System.out.println("invalid length");
                break;

            }
            if(numbers.get(i) % 2 == 0 && numbers.get(i + 1) % 2 == 0){
                isThePairEven = true;
            } else if(numbers.get(i) % 2 == 1 && numbers.get(i + 1) % 2 == 1) {
                isThePairOdd = true;
            }
            System.out.printf("%s, %s -> ", numbers.get(i), numbers.get(i+1));
            if(isThePairEven){
                System.out.println("both are even");
            } else if(isThePairOdd){
                System.out.println("both are odd");
            } else {
                System.out.println("different");
            }
        }

    }
}
