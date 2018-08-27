package _01_IntroToJava_Exercises;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class _12_VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] parkVehicles = scanner.nextLine().split(" ");
        int soldVehicles = 0;

        while(true){
            String [] line = scanner.nextLine().split(" ");

            String vehicle =  line[0].toLowerCase().charAt(0)+ line[2];
            if(line[0].equals("End")){
                break;
            }

            for (int i = 0; i < parkVehicles.length ; i++) {
                if(parkVehicles[i].equals(vehicle)){
                        int price = (int)(parkVehicles[i].charAt(0)) * Integer.parseInt(parkVehicles[i].substring(1));
                        soldVehicles++;
                        parkVehicles[i] = " ";
                        System.out.printf("Yes, sold for %d$%n", price);
                        break;
                    }

                    if(i == parkVehicles.length - 1){
                        System.out.println("No");
                    }
                }

            }
        List result = new LinkedList();
        for (String parkVehicle : parkVehicles) {
            if (!parkVehicle.equals(" "))
                result.add(parkVehicle);
        }
        System.out.print("Vehicles left: ");
        System.out.println(String.join(", ",result));

        System.out.printf("Vehicles sold: %d",soldVehicles);

    }
}