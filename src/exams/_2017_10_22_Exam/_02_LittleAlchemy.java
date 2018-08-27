package exams._2017_10_22_Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _02_LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> stones = new ArrayDeque<>();
        stones.addAll(numbers);
        ArrayDeque<Integer> gold = new ArrayDeque<>();

        String line;
        while(!"Revision".equals(line = reader.readLine())){
            String [] command = line.split("\\s+");
            switch (command[0]){
                case "Apply":
                    if(!stones.isEmpty()){
                        int amountOfAcid = Integer.parseInt(command[2]);
                        for (int i = 0; i < amountOfAcid; i++) {
                            if(stones.isEmpty()){
                               break;
                            }else {
                                int currStone = stones.pop();
                                currStone -= 1;
                                if (currStone > 0) {
                                    stones.add(currStone);
                                }else{
                                    gold.add(1);
                                }
                            }
                        }
                    }
                    break;
                case "Air":
                    if(!gold.isEmpty()){
                        stones.add(Integer.parseInt(command[2]));
                        gold.pop();
                    }
                    break;
            }
        }

        for (Integer stone : stones) {
            System.out.print(stone + " ");
        }
        System.out.println("\n" + gold.size());
    }
}