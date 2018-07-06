package _05_ObjectsClassesAndCollections_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(" ");

        int numsToPush =Integer.parseInt(input[0]);
        int numsToPop = Integer.parseInt(input[1]);
        int checkNum = Integer.parseInt(input[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String [] line = scanner.nextLine().split(" ");
        for (int i = 0; i < numsToPush; i++) {
            stack.push(Integer.parseInt(line[i]));
        }

        for (int i = 0; i < numsToPop; i++) {
            stack.pop();
        }
        if(stack.contains(checkNum)) {
            System.out.println(stack.contains(checkNum));
        } else if(stack.isEmpty()){
            System.out.println("0");
        } else {
            int minNumber = Integer.MAX_VALUE;
            for (int element: stack) {
                if(element < minNumber){
                    minNumber = element;
                }
            }
            System.out.println(minNumber);
        }
    }
}
