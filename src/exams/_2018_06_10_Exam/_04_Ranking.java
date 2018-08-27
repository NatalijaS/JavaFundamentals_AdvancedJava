package exams._2018_06_10_Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _04_Ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Contest> contests = new HashMap<>();
        String line1;
        while (!"end of contests".equals(line1 = reader.readLine())) {
            String[] tokens = line1.split(":");

            contests.put(tokens[0], new Contest(tokens[0], tokens[1]));
        }

        Map<String, User> users = new HashMap<>();
        String line2;
        while (!"end of submissions".equals(line2 = reader.readLine())) {
            String[] tokens = line2.split("=>");

            if (contests.containsKey(tokens[0])) {
                if (contests.get(tokens[0]).getPassword().equals(tokens[1])) {
                    users.putIfAbsent(tokens[2], new User(tokens[2]));
                    users.get(tokens[2]).addContest(new Contest(tokens[0], tokens[1]), Integer.parseInt(tokens[3]));
                }
            }
        }

        users.entrySet().stream().sorted(Comparator.comparing(u -> u.getValue().getTotalPoints(), Comparator.reverseOrder()))
                .limit(1)
                .forEach(kvp -> System.out.printf("Best candidate is %s with total %d points.%n"
                        , kvp.getKey(), kvp.getValue().getTotalPoints()));

        System.out.println("Ranking:");
        users.entrySet().stream().sorted(Comparator.comparing(u -> u.getValue().getName()))
                .forEach(u -> {
                    System.out.println(u.getKey());
                    u.getValue().getPointsContests().entrySet().stream()
                            .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                            .forEach(c -> System.out.println(String.format("#  %s -> %d",
                                    c.getKey(), c.getValue())));
                });


    }

    private static class Contest {

        private String name;
        private String password;

        Contest(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        String getPassword() {
            return password;
        }
    }

    private static class User {

        private String name;
        private Map<String, Integer> pointsContests;

        User(String name) {
            this.name = name;
            this.pointsContests = new HashMap<>();
        }

        public String getName() {
            return name;
        }

        Map<String, Integer> getPointsContests() {
            return pointsContests;
        }

        void addContest(Contest contest, int points) {
            if (this.pointsContests.containsKey(contest.getName())) {
                int biggerPoints = this.pointsContests.get(contest.getName()) > points ?
                        this.pointsContests.get(contest.getName()) : points;
                this.pointsContests.put(contest.getName(), biggerPoints);
                return;
            }
            this.pointsContests.put(contest.getName(), points);
        }

        int getTotalPoints() {
            int sum = 0;
            for (Integer integer : pointsContests.values()) {
                sum += integer;
            }
            return sum;
        }
    }
}


