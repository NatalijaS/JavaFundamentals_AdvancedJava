package _05_ObjectsClassesAndCollections_Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _04_TruckTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = Long.parseLong(scanner.nextLine());
        long pumpNo = 0;
        long pumpNo1 =0;

        ArrayDeque<String> pumps = new ArrayDeque<>();
        for (int i = 0; i < n ; i++) {
            pumps.add(scanner.nextLine());
        }
        boolean isALLPathValid = true;
        long allFuel = 0;

        while(pumps.size() > 0){
            long currentFuel = 0;
            long [] currentPump = Arrays.stream(pumps.remove().split(" ")).mapToLong(Long::valueOf).toArray();
            currentFuel = currentPump[0] - currentPump[1];
            allFuel += currentFuel;
            if (allFuel < 0)
            {
                pumpNo1 = pumpNo;
                allFuel = 0;
                isALLPathValid = false;
            }
            pumpNo++;
        }
        if (pumpNo1 + 1 == n || isALLPathValid)
        {
            System.out.println("0");
        }
        else
        {
            System.out.println(pumpNo1 +1);
        }
    }
}
