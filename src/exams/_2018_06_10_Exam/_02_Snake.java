package exams._2018_06_10_Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02_Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int screenSide = Integer.parseInt(reader.readLine());
        String[] commands = reader.readLine().split(", ");

        int [] startIndex = new int[2];
        int foodCount = 0;
        String[][] screen = new String[screenSide][screenSide];
        for (int i = 0; i < screenSide; i++) {
            String [] tokens = reader.readLine().split(" ");
            for (int j = 0; j < screenSide; j++) {
                screen[i][j] = tokens[j];
                if(tokens[j].equals("s")){
                    startIndex[0] = i;
                    startIndex[1] = j;
                }
                if(tokens[j].equals("f")){
                    foodCount++;
                }
            }
        }


        int [] currentIndex = new int[2];
        int snakeLength = 1;
        for (int i = 0; i < commands.length; i++) {
            if(foodCount <= 0){
                break;
            }
            switch (commands[i]){
                case "up":
                    if(i == 0){
                        currentIndex[0] = startIndex[0] - 1;
                        currentIndex[1] = startIndex[1];
                    }else{
                        currentIndex[0] = currentIndex[0] - 1;
                    }
                    if(currentIndex[0] < 0){
                        currentIndex[0] = screenSide - 1;
                        currentIndex[1] = screenSide - 1;
                    }
                    if(screen[currentIndex[0]][currentIndex[1]].equals("f")){
                        foodCount--;
                        snakeLength++;
                    }
                    if(screen[currentIndex[0]][currentIndex[1]].equals("e")){
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "down":
                    if(i == 0){
                        currentIndex[0] = startIndex[0] + 1;
                        currentIndex[1] = startIndex[1];
                    }else{
                        currentIndex[0] = currentIndex[0] + 1;
                    }
                    if(currentIndex[0] >= screenSide){
                        currentIndex[0] = 0;
                        currentIndex[1] = 0;
                    }
                    if(screen[currentIndex[0]][currentIndex[1]].equals("f")){
                        foodCount--;
                        snakeLength++;
                    }
                    if(screen[currentIndex[0]][currentIndex[1]].equals("e")){
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "right":
                    if(i == 0){
                        currentIndex[0] = startIndex[0];
                        currentIndex[1] = startIndex[1] + 1;
                    }else {
                        currentIndex[1] = currentIndex[1] + 1;
                    }
                    if(currentIndex[1] >= screenSide){
                        currentIndex[1] = 0;
                    }
                    if(screen[currentIndex[0]][currentIndex[1]].equals("f")){
                        foodCount--;
                        snakeLength++;
                    }
                    if(screen[currentIndex[0]][currentIndex[1]].equals("e")){
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "left":
                    if(i == 0){
                        currentIndex[0] = startIndex[0];
                        currentIndex[1] = startIndex[1] - 1;
                    }else{
                        currentIndex[1] = currentIndex[1] - 1;
                    }
                    if(currentIndex[1] < 0){
                        currentIndex[1] = screenSide - 1;
                    }
                    if(screen[currentIndex[0]][currentIndex[1]].equals("f")){
                        foodCount--;
                        snakeLength++;
                    }
                    if(screen[currentIndex[0]][currentIndex[1]].equals("e")){
                        System.out.println("You lose! Killed by an enemy!");
                       return;
                    }
                    break;
            }
        }
        if(foodCount == 0){
            System.out.println(String.format("You win! Final snake length is %d", snakeLength));
        }else{
            System.out.println(String.format("You lose! There is still %d food to be eaten.", foodCount));
        }
    }
}
