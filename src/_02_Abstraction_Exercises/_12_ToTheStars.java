package _02_Abstraction_Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class _12_ToTheStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<StarSystem> systems = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String[] input = scanner.nextLine().split(" ");
            String systemName = input[0];
            double centerPointX = Double.parseDouble(input[1]);
            double centerPointY = Double.parseDouble(input[2]);

            StarSystem currentSystem = new StarSystem(systemName, centerPointX, centerPointY);

            systems.add(currentSystem);
        }

        String[] location = scanner.nextLine().split(" ");
        int moves = Integer.parseInt(scanner.nextLine());

        double currentLocationX = Double.parseDouble(location[0]);
        double currentLocationY = Double.parseDouble(location[1]);

        while (moves >= 0) {
            String currentLocation = "space";

            for (StarSystem system : systems) {
                if (system.isInsideStarSystem(currentLocationX, currentLocationY)){
                    currentLocation = system.getName().toLowerCase();
                }
            }

            System.out.println(currentLocation);
            currentLocationY++;
            moves--;
        }
    }
}

class StarSystem {
    String name;
    private double centerPointX;
    private double centerPointY;

    private double leftEdge;
    private double rightEdge;

    private double lowerEdge;
    private double upperEdge;

    public StarSystem(String name, double centerPointX, double centerPointY) {
        this.name = name;
        this.centerPointX = centerPointX;
        this.centerPointY = centerPointY;
        this.leftEdge = this.getCenterPointX() - 1;
        this.rightEdge = this.getCenterPointX() + 1;
        this.lowerEdge = centerPointY - 1;
        this.upperEdge = centerPointY + 1;
    }

    public boolean isInsideStarSystem(double coordinateX, double coordinateY) {
        if (coordinateX >= this.leftEdge && coordinateX <= this.rightEdge
                && coordinateY >= this.lowerEdge && coordinateY <= this.upperEdge) {
            return true;
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCenterPointX() {
        return centerPointX;
    }

}
