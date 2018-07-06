package _02_Abstraction_Exercises;


import java.util.Scanner;

public class _09_TerroristsWin {
    public static void main(String[] args) { Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] result = input.toCharArray();

        int tempIndex = 0;

        while (input.indexOf('|', tempIndex) != -1) {

            int startIndex = input.indexOf('|', tempIndex);
            int endIndex = input.indexOf('|', startIndex + 1);
            char[] bombArray = input.substring(startIndex + 1, endIndex).toCharArray();

            int sum = 0;

            for (char c : bombArray) {
                sum += c;
            }

            int bombPower = sum % 10;

            int destroyedCharsLeftEdge = Math.max(0, startIndex - bombPower);
            int destroyedCharsRightEdge = Math.min(input.length() - 1, endIndex + bombPower);

            for (int i = destroyedCharsLeftEdge; i <= destroyedCharsRightEdge; i++) {
                result[i] = '.';
            }

            tempIndex = endIndex + 1;
        }

        System.out.println(result);

    }
}
//public class Demo {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        char[] input = reader.readLine().toCharArray();
//        char [] result = input;
//
//
//        for (int i = 0; i < input.length; i++) {
//            int startIndex = -1;
//            int endIndex = -1;
//            if(input[i] == '|'){
//                startIndex = i;
//                for (int j = i + 1; j < input.length; j++) {
//                    if(input[j] == '|'){
//                        endIndex =j;
//                        break;
//                    }
//                }
//            }
//            if(startIndex >= 0 && endIndex > 0){
//                int sum =0;
//                for (int j = startIndex + 1; j <endIndex ; j++) {
//                    sum += input[j];
//                }
//                int bombPower = sum %10;
//                int destroyedCharsLeftEdge = Math.max(0, startIndex - bombPower);
//                int destroyedCharsRightEdge = Math.min(input.length - 1, endIndex + bombPower);
//                for (int k = destroyedCharsLeftEdge; k <= destroyedCharsRightEdge; k++) {
//                    result[k] = '.';
//                }
//            }
//
//        }
//        for (char c : result) {
//            System.out.print(c);
//        }
//    }
//}
