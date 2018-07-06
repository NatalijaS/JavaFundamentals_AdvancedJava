package exams.ExamPreparationI_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputRegex = "([A-Za-z]+) - ([A-Za-z]+) result (\\d+):(\\d+)";

        Pattern pattern = Pattern.compile(inputRegex);
        Map<String, Team> teams = new HashMap<>();
        String input = reader.readLine();
        while (!"Season End".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            matcher.find();
            String homeTeam = matcher.group(1);
            String guestTeam = matcher.group(2);
            String homeResult = matcher.group(3);
            String guestResult = matcher.group(4);

            if (!teams.containsKey(homeTeam)) {
                Team home = new Team(homeTeam);
                home.addGame(guestTeam, homeResult + ":" + guestResult);
                teams.put(home.getName(), home);
            } else {
                teams.get(homeTeam).addGame(guestTeam, homeResult + ":" + guestResult);
            }

            if (!teams.containsKey(guestTeam)) {
                Team guest = new Team(guestTeam);
                guest.addGame(homeTeam, guestResult + ":" + homeResult);
                teams.put(guestTeam, guest);

            } else {
                teams.get(guestTeam).addGame(homeTeam, guestResult + ":" + homeResult);
            }

            input = reader.readLine();
        }

//        teams = teams.keySet().stream().sorted(String::compareTo).collect(Collectors.groupingBy(teams.va));

        String[] outputCommand = reader.readLine().split(", ");

        for (int i = 0; i < outputCommand.length; i++) {
            String teamName = outputCommand[i];

            Set<Map.Entry<String, List<String>>> teamGames = teams.get(teamName).getGames();

            for (Map.Entry<String, List<String>> teamGame : teamGames) {

                for (String game : teamGame.getValue()) {
                    System.out.println(teamName + " - " + teamGame.getKey() + " -> " + game);
                }
            }
        }
    }
}

class Team {
    private String Name;
    private Map<String, List<String>> games;

    public Team(String name) {
        Name = name;
        this.games = new HashMap<>();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Set<Map.Entry<String, List<String>>> getGames() {
        return games.entrySet();
    }

    public void addGame(String name, String result) {
        if (!this.games.containsKey(name)) {
            this.games.put(name, new ArrayList<>());
        }
        this.games.get(name).add(result);
    }

}
