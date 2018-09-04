package exams._2018_08_27_MyExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _04_Agents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Mission> missions = new HashMap<>();
        Map<String, Agent> agents = new HashMap<>();
        Map<String, Agent> assignedAgents = new LinkedHashMap<>();

        String line;
        while (!"registration".equals(line = reader.readLine())) {

            if (line.startsWith("#")) {
                String[] tokens = line.split(":");
                String missionName = tokens[0];
                double missionRating = Double.parseDouble(tokens[1]);
                missions.putIfAbsent(missionName, new Mission(missionName, missionRating));

            } else {
                if (line.substring(line.length() - 3).startsWith("0")) {
                    agents.put(line, new Agent(line));
                }
            }
        }

        String line2;
        while (!"operate".equals(line2 = reader.readLine())) {
            String[] tokens = line2.split("->");
            String commandName = tokens[0];
            switch (commandName) {
                case "assign":
                    String agentName = tokens[1];
                    String missionName = tokens[2];

                    if (missions.containsKey(missionName)) {
                        agents.get(agentName).addMission(missions.get(missionName));
                        assignedAgents.putIfAbsent(agentName, agents.get(agentName));
                    }

                    break;
                case "abort":
                    String mission = tokens[1];

                    for (Agent agent : agents.values()) {
                        agent.removeMission(missions.get(mission));
                    }
                    break;
                case "change":
                    String agentName1 = tokens[1];
                    String agentName2 = tokens[2];

                    Set<Mission> swap = agents.get(agentName1).getMissions();
                    agents.get(agentName1).setMissions(agents.get(agentName2).getMissions());
                    agents.get(agentName2).setMissions(swap);
                    break;
            }
        }


        assignedAgents.values().stream().sorted().forEach(a -> {
            if (a.getMissions().size() != 0) {
                System.out.println(String.format("Agent: %s - Total Rating: %.2f"
                        , a.getName(), a.getTotalMissionRating()));

                a.getMissions().stream().sorted().forEach(m ->
                                System.out.println(String.format("- %s -> %.2f", m.getName(), m.getRating())));
            }
        });
    }

    private static class Agent implements Comparable<Agent> {

        private String name;
        private Set<Mission> missions;

        Agent(String name) {
            this.name = name;
            this.missions = new LinkedHashSet<>();
        }

        public String getName() {
            return name;
        }

        Set<Mission> getMissions() {
            return missions;
        }

        void setMissions(Set<Mission> missions) {
            this.missions = missions;
        }

        void addMission(Mission mission) {
            if (!this.missions.contains(mission)) {
                this.missions.add(mission);
            }
        }

        void removeMission(Mission mission) {
            if (this.missions.contains(mission)) {
                this.missions.remove(mission);
            }
        }

        private double getTotalMissionRating() {
            double sum = 0;
            for (Mission mission : missions) {
                sum += mission.getRating();
            }

            return sum;
        }

        @Override
        public int compareTo(Agent o) {
            return Double.compare(o.getTotalMissionRating(), this.getTotalMissionRating());
        }
    }

    private static class Mission implements Comparable<Mission>{

        private String name;
        private double rating;

        Mission(String name, double rating) {
            this.name = name;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        double getRating() {
            return rating;
        }

        @Override
        public int compareTo(Mission o) {
            int compare = Double.compare(o.getRating(), this.getRating());
            if(compare == 0){
                compare = 0;
            }
            return compare;
        }
    }
}
