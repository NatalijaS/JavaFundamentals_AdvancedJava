package _05_ObjectsClassesAndCollections_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _02_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n ; i++) {
            String [] line = scanner.nextLine().split(" ");
            int number = Integer.parseInt(line[0]);

            switch (number){
                case 1:
                    stack.push(Integer.valueOf(line[1]));
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    int maxNumber = Integer.MIN_VALUE;
                        for (int element: stack) {
                            if(element > maxNumber){
                                maxNumber = element;
                            }
                        }
                    System.out.println(maxNumber);
                    break;
            }
        }
    }
}
