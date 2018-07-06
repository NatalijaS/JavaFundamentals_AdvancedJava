package exams.Exam_22_10_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> stones = new ArrayDeque<>();
        stones.addAll(numbers);
        ArrayDeque<Integer> gold = new ArrayDeque<>();

        String line = reader.readLine();
        while(!"Revision".equals(line)){
            String [] command = line.split("\\s+");

            switch (command[0]){
                case "Apply":
                    if(stones.isEmpty()){
                       break;
                    }else{
                        int amoundOfAcid = Integer.parseInt(command[2]);
                        for (int i = 0; i < amoundOfAcid; i++) {
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
                    if(gold.isEmpty()){
                       break;
                    }else{
                        stones.add(Integer.parseInt(command[2]));
                        gold.pop();
                    }
                    break;
            }
            line = reader.readLine();
        }
        for (Integer stone : stones) {
            System.out.print(stone + " ");
        }
        System.out.println("\n" + gold.size());
    }
}