import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    List<Game> games = new ArrayList<Game>();

    public void startGame(String homeTeamName, String awayTeamName) {
        var home = new Team(homeTeamName);
        var away = new Team(awayTeamName);
        var game = new Game(home, away);
        games.add(game);
    }

    public List<Game> getSummary() {
        return new ArrayList<>(games);
    }
}
