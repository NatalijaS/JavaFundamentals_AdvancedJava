package _01_IntroToJava_Exercises;

import java.util.Scanner;

public class _11_GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playersCount = Integer.parseInt(scanner.nextLine());

        String winner = "";
        int winnerPoints = Integer.MIN_VALUE;
        for (int i = 0; i < playersCount ; i++) {

            String playerName = scanner.nextLine();
            int playerScore = Integer.parseInt(scanner.nextLine());

            int playerNameScore =0 ;
            for (int j = 0; j < playerName.length() ; j++) {
                if((int)(playerName.charAt(j)) % 2 == 0){
                    playerNameScore += (int)(playerName.charAt(j));
                }else{
                    playerNameScore -= (int)(playerName.charAt(j));
                }
            }
            playerScore += playerNameScore;

            if(playerScore > winnerPoints){
                winner = playerName;
                winnerPoints = playerScore;
            }
        }

        System.out.printf("The winner is %s - %d points", winner, winnerPoints);
    }
}
