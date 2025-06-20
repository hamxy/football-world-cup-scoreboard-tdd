import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private final List<Game> games = new ArrayList<>();

    public void startGame(String home, String away) {
        games.add(new Game(home, away));
    }

    public List<Game> getSummary() {
        return new ArrayList<>(games);
    }
}
