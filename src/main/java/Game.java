public class Game {
    private final Team home;
    private final Team away;
    private int homeScore;
    private int awayScore;

    public Game(String home, String away) {
        this.home = new Team(home);
        this.away = new Team(away);
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }
}
