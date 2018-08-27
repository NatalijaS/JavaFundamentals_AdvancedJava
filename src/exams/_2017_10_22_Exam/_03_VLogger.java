package exams._2017_10_22_Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _03_VLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, VLogger> v_loggers = new HashMap<>();

        String line;
        while (!"Statistics".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String vLoggerName = tokens[0];
            String command = tokens[1];

            switch (command) {
                case "joined":
                    v_loggers.putIfAbsent(vLoggerName, new VLogger(vLoggerName));
                    break;
                case "followed":
                    String vLoggerToFollowName = tokens[2];

                    if (v_loggers.containsKey(vLoggerName) && v_loggers.containsKey(vLoggerToFollowName)) {
                        v_loggers.get(vLoggerName).addFollowing(v_loggers.get(vLoggerToFollowName));
                        v_loggers.get(vLoggerToFollowName).addFollowers(v_loggers.get(vLoggerName));
                    }
                    break;
            }
        }

        System.out.println(String.format("The V-Logger has a total of %d vloggers in its logs.",
                v_loggers.values().size()));

        v_loggers.values().stream().sorted().limit(1).forEach(v -> {
            System.out.println(String.format("1. %s : %d followers, %d following"
                    , v.getName(), v.getFollowers().values().size(), v.getFollowing().values().size()));

            if (v.getFollowers().values().size() != 0) {
                v.getFollowers().values().stream().sorted(Comparator.comparing(VLogger::getName))
                        .forEach(f -> System.out.println(String.format("*  %s", f.getName())));
            }
        });

        final int[] count = {1};
        v_loggers.values().stream().sorted().skip(1)
                .forEach(v -> System.out.println(String.format("%d. %s : %d followers, %d following"
                    , ++count[0], v.getName(), v.getFollowers().values().size(), v.getFollowing().values().size())));
    }

    private static class VLogger implements Comparable<VLogger> {
        private String name;
        private Map<String, VLogger> following;
        private Map<String, VLogger> followers;

        VLogger(String name) {
            this.name = name;
            this.following = new HashMap<>();
            this.followers = new HashMap<>();
        }

        public String getName() {
            return name;
        }

        Map<String, VLogger> getFollowing() {
            return following;
        }

        Map<String, VLogger> getFollowers() {
            return followers;
        }

        void addFollowing(VLogger VLogger) {
            if (!VLogger.getName().equals(this.name) && !this.following.containsKey(VLogger.getName())) {
                this.following.put(VLogger.getName(), VLogger);
            }
        }

        void addFollowers(VLogger VLogger) {
            if (!VLogger.getName().equals(this.name) && !this.followers.containsKey(VLogger.getName())) {
                this.followers.put(VLogger.getName(), VLogger);
            }
        }

        @Override
        public int compareTo(VLogger o) {
            int compare = Integer.compare(o.followers.values().size(), this.followers.values().size());
            if (compare == 0) {
                compare = Integer.compare(this.following.values().size(), o.following.values().size());
            }

            return compare;
        }
    }
}
