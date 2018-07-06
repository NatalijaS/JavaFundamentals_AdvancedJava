package _05_ObjectsClassesAndCollections_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();

        char [] input = scanner.nextLine().toCharArray();

        for (char c : input) {
            stack.push(c);
            queue.add(c);
        }
        boolean hasMatch = false;
        for (int i = 0; i < input.length/2; i++) {
            switch (queue.remove()){
                case '(':
                    if(stack.pop() == ')'){
                        hasMatch = true;
                    }
                    else{
                        hasMatch = false;
                    }
                    break;
                case '[':
                    if(stack.pop() == ']'){
                        hasMatch = true;
                    }
                    else{
                        hasMatch = false;
                    }
                    break;
                case '{':
                    if(stack.pop() == '}'){
                        hasMatch = true;
                    }
                    else{
                        hasMatch = false;
                    }
                    break;
            }
        }

       if(hasMatch){
           System.out.println("YES");
       }else{
           System.out.println("NO");
       }
    }
}
