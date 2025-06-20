public class Game {
    private final Team home;
    private final Team away;
    private int homeScore;
    private int awayScore;

    public Game(String home, String away) {
        if (home.equalsIgnoreCase(away))
            throw new IllegalArgumentException("Home and away are the same");

        this.home = new Team(home);
        this.away = new Team(away);
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public String getHomeName() {
        return home.getName();
    }

    public String getAwayName() {
        return away.getName();
    }
}
