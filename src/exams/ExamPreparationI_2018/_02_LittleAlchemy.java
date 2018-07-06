package exams.ExamPreparationI_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class _02_LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String [] stones = reader.readLine().split(" ");

        Queue<Integer> stoneStorage = new ArrayDeque<>();
        Deque<Integer> goldenStorage = new ArrayDeque<>();

        if(!stones[0].equals("")) {
            for (int i = 0; i < stones.length; i++) {
                stoneStorage.add(Integer.valueOf(stones[i]));
            }
        }

        String command = reader.readLine();
        while(!command.equals("Revision")){
            String [] tokens = command.split("\\s+");
            switch (tokens[0]){
                case "Apply":
                    if(!stoneStorage.isEmpty()){
                        for (int i = 0; i < Integer.parseInt(tokens[2]); i++) {
                            if(stoneStorage.isEmpty()){
                                break;
                            }else{
                                int stone = stoneStorage.remove();
                                stone -=1;
                                if(stone <=0){
                                    goldenStorage.push(1);
                                }else{
                                    stoneStorage.add(stone);
                                }
                            }
                        }
                    }
                    break;
                case "Air":
                    if(!goldenStorage.isEmpty()){
                        stoneStorage.add(goldenStorage.poll() + Integer.parseInt(tokens[2]) - 1);
                    }
                    break;
            }

            command = reader.readLine();
        }
        for (Integer integer : stoneStorage) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println(goldenStorage.size());
    }
}
