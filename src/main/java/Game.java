public class Game {
    private final Team home;
    private final Team away;

    public Game(String home, String away) {
        this.home = new Team(home);
        this.away = new Team(away);
    }
}
