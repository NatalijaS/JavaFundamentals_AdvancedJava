package exams.Exam_22_10_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> vloggers = new ArrayList<>();
        Map<String, List<String>> vloggersFollowing = new TreeMap<>();
        Map<String, List<String>> vloggersFollowers = new TreeMap<>();

        String line = reader.readLine();
        while(!"Statistics".equals(line)){
            String [] tokens = line.split(" ");
            switch (tokens[1]){
                case "joined":
                    String vloggerName = tokens[0];
                    if(vloggers.contains(vloggerName)){
                        break;
                    }else{
                        vloggers.add(vloggerName);
                        vloggersFollowing.putIfAbsent(vloggerName,new ArrayList<>());
                        vloggersFollowers.putIfAbsent(vloggerName, new ArrayList<>());
                    }
                    break;
                case "followed":
                    String vloggerNameAction = tokens[0];
                    String vloggerToFollow = tokens[2];
                    if(!vloggers.contains(vloggerToFollow)){
                        break;
                    }else {
//                        vloggersFollowers.put(vloggerToFollow, vloggerNameAction);
////                        vloggersFollowing.put(vloggerNameAction, vloggerToFollow);
//                        vloggersFollowers.get(vloggerToFollow).putIfAbsent(vloggerNameAction,0);
//                        vloggersFollowers.get(vloggerToFollow).put(vloggerNameAction,
//                                vloggersFollowers.get(vloggerToFollow).get(vloggerNameAction) + 1 );
//
//                        vloggersFollowing.get(vloggerNameAction).putIfAbsent(vloggerToFollow,0);
//                        vloggersFollowing.get(vloggerNameAction).put(vloggerToFollow,
//                                vloggersFollowing.get(vloggerNameAction).get(vloggerToFollow) + 1 );

                        vloggersFollowers.get(vloggerToFollow).add(vloggerNameAction);
                        vloggersFollowing.get(vloggerNameAction).add(vloggerToFollow);

                    }
                    break;
            }

            line = reader.readLine();
        }

        System.out.println("The V-Logger has a total of " + vloggers.size() + " vloggers in its logs.");

        StringBuilder result = new StringBuilder();

       // vloggersFollowers.entrySet().stream().sorted(Comparator.comparing(a-> a.getValue();
//        int count = 1;

//        for (Map.Entry<String, List<String>> entry : vloggersFollowing.entrySet()) {
//            String maxVlogger = "";
//            int maxFollow = 0;
//            if (entry.getValue().size() > maxFollow) {
//                maxFollow = entry.getValue().size();
//                maxVlogger = entry.getKey();
//            }
////            result.append(count + maxVlogger + ":" + maxFollow + "followers , " + vloggersFollowing.get(maxVlogger).size() +
////            " following\n" + vloggersFollowing.get(maxVlogger).forEach(x - > System.out.println("* " + x1)))
//
//            System.out.println(count + ". " + maxVlogger + ":" + maxFollow + "followers , " + vloggersFollowing.get(maxVlogger).size() +
//                    +vloggersFollowers.get(maxVlogger).size() + " following");
//            vloggersFollowing.get(maxVlogger).forEach(x -> System.out.println("* " + x));
//        }


//        .entrySet().stream().sorted((a,b) -> Long.compare(b.getValue(), a.getValue()))
//                .forEach(v -> {
//                    result.append(v.getKey()).append(" - (").append(v.getValue()).append(")").append("\n");
//                    playerOpponents.get(v.getKey()).forEach(s -> result.append(s).append("\n"));
//                });
//        System.out.println(result);
    }
}
