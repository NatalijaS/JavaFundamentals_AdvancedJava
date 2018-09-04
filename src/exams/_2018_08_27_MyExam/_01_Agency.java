package exams._2018_08_27_MyExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class _01_Agency {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] ids = reader.readLine().split("\\s+");
        String[] agentsNames = reader.readLine().split("\\s+");

        ArrayDeque<String> idStack = new ArrayDeque<>();
        for (String id : ids) {
            idStack.push(id);
        }
        ArrayDeque<String> agentQueue = new ArrayDeque<>();
        agentQueue.addAll(Arrays.asList(agentsNames));

        String line;
        while (!"stop".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "add-ID":
                    idStack.push(tokens[1]);
                    break;
                case "add-agent":
                    agentQueue.add(tokens[1]);
                    break;
                case "remove-ID":
                    System.out.println(String.format("%s has been removed. ", idStack.pop()));
                    break;
                case "remove-agent":
                    System.out.println(String.format("%s has left the queue.", agentQueue.removeLast()));
                    break;
                case "sort-ID":
                    idStack = idStack.stream().sorted(Comparator.reverseOrder())
                            .collect(Collectors.toCollection(ArrayDeque::new));
                    break;
            }
        }

        int smaller = idStack.size() >= agentQueue.size() ? agentQueue.size() : idStack.size();

        for (int i = 0; i < smaller; i++) {
            System.out.println(String.format("%s takes ID number: %s", agentQueue.poll(), idStack.pop()));
        }

        if (idStack.size() > agentQueue.size()) {
            System.out.println("No more agents left.");
            for (String s : idStack) {
                System.out.println(String.format("ID number: %s", s));
            }
        } else {
            for (String s : agentQueue) {
                System.out.println(String.format("%s does not have an ID.", s));
            }
        }
    }
}
