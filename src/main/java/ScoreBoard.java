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
        return games.stream().anyMatch(
                game -> game.getHomeName().equalsIgnoreCase(team) || game.getAwayName().equalsIgnoreCase(team)
        );
    }

    public List<Game> getSummary() {
        return new ArrayList<>(games);
    }

    public void updateScore(String home, String away, int homeScore, int awayScore) {
        if (homeScore < 0 || awayScore < 0)
            throw new IllegalArgumentException("Score cannot be negative");

        var game = findGame(home, away);
        game.updateScore(homeScore, awayScore);
    }

    private Game findGame(String home, String away) {
        for (Game game : games) {
            if (game.getHomeName().equalsIgnoreCase(home) && game.getAwayName().equalsIgnoreCase(away))
                return game;
        }
        throw new IllegalArgumentException("Game not found: " + home + " vs " + away);
    }

    public void finishGame(String home, String away) {
        var game = findGame(home, away);
        games.remove(game);
    }
}
