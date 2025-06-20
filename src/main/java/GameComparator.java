import java.util.Comparator;
import java.util.List;

public class GameComparator implements Comparator<Game> {
    private final List<Game> games;

    public GameComparator(List<Game> games) {
        this.games = games;
    }

    @Override
    public int compare(Game g1, Game g2) {
        int totalScore1 = g1.getHomeScore() + g1.getAwayScore();
        int totalScore2 = g2.getHomeScore() + g2.getAwayScore();

        // Compare total scores in descending order:
        if (totalScore1 != totalScore2) {
            return Integer.compare(totalScore2, totalScore1);
        }

        // If total scores are equal, compare their indexes
        int index1 = games.indexOf(g1);
        int index2 = games.indexOf(g2);

        return Integer.compare(index2, index1);
    }
}