import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private final List<Game> games = new ArrayList<>();

    public void startGame(String home, String away) {
        if (isAlreadyPlaying(home) || isAlreadyPlaying(away))
            throw new IllegalArgumentException("A team cannot play in more than one game at a time");
        games.add(new Game(home, away));
    }

    private boolean isAlreadyPlaying(String team) {
        for (Game game : games) {
            if (game.getHomeName().equalsIgnoreCase(team) || game.getAwayName().equalsIgnoreCase(team))
                return true;
        }
        return false;
    }

    public List<Game> getSummary() {
        return new ArrayList<>(games);
    }
}
