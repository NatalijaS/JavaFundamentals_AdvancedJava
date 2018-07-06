package _05_ObjectsClassesAndCollections_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(" ");
        int numsToAdd = Integer.parseInt(input[0]);
        int numsToRemove = Integer.parseInt(input[1]);
        int numToFind = Integer.parseInt(input[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String [] input2 = scanner.nextLine().split(" ");
        for (int i = 0; i < numsToAdd; i++) {
            int num = Integer.parseInt(input2[i]);
            queue.add(num);
        }

        for (int i = 0; i < numsToRemove; i++) {
            queue.remove();
        }

        if(queue.contains(numToFind)){
            System.out.println("true");
        }else if(queue.isEmpty()){
            System.out.println(0);
        }else{
            int min = Integer.MAX_VALUE;
            for (Integer integer : queue) {
                if(integer < min){
                    min = integer;
                }
            }
            System.out.println(min);
        }

    }
}
