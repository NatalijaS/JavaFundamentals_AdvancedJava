package _04_DataRepresentationAndManipulation_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02_NestedLoopsToRecursion {
    public static int numberOfLoops;
    public static int numberOfIterations;
    public static int[] loops;

    public static void main(String[] args) throws IOException {
        BufferedReader  reader = new BufferedReader(new InputStreamReader(System.in));

        numberOfLoops = Integer.parseInt(reader.readLine());
        numberOfIterations = numberOfLoops;

        loops = new int[numberOfLoops];
        nastedLoops(0);
    }
    public static void nastedLoops(int currentLoop){
        if(currentLoop == numberOfLoops){
            printLoops();
            return;
        }
        for (int i = 1; i <= numberOfIterations; i++) {
            loops[currentLoop] = i;
            nastedLoops(currentLoop + 1);
        }
    }
    public static void printLoops(){
        for (int loop : loops) {
            System.out.print(loop + " ");
        }
        System.out.println();
    }
}
