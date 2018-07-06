package _04_DataRepresentationAndManipulation_Lab;

import java.util.Collections;
import java.util.Scanner;

public class _06_RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        draw(num);
    }
    public  static void draw(int num){
        if(num == 0){
            return;
        }else{
            System.out.println(String.join("", Collections.nCopies(num, "*")));
            draw(num - 1);
            System.out.println(String.join("", Collections.nCopies(num, "#")));
        }

    }
}
