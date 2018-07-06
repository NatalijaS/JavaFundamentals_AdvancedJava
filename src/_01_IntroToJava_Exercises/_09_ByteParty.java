package _01_IntroToJava_Exercises;


import java.util.Scanner;

public class _09_ByteParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int [] numbers = new int[a];

        for (int i = 0; i <a ; i++) {
            int b = Integer.parseInt(scanner.nextLine());
            numbers[i] = b;
        }

        while(true){
            String [] line = scanner.nextLine().split("\\s+");

            if(line[0].equals("party")){
                for (int i = 0; i <numbers.length ; i++) {
                    System.out.println(numbers[i]);
                }
                break;
            }

            int action = Integer.parseInt(line[0]);
            int position = Integer.parseInt(line[1]);

            switch (action){
                case -1:
                    for (int i = 0; i <numbers.length ; i++) {
                        numbers[i] = numbers[i] ^ (1 << position);
                    }
                    break;
                case 0:
                    for (int i = 0; i <numbers.length ; i++) {
                        numbers[i] = numbers[i] & ~(1 << position);
                    }
                    break;
                case 1:
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] | (1 << position);
                    }
                    break;
            }

        }
    }
}
