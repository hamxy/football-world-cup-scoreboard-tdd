import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardTest {
    private ScoreBoard scoreBoard;

    @BeforeEach
    public void setUp() {
        scoreBoard = new ScoreBoard();
    }

    @Test
    public void shouldAddGameToList() {
        scoreBoard.startGame("Mexico", "Canada");
        List<Game> games = scoreBoard.getSummary();
        assertEquals(1, games.size());
    }
}
