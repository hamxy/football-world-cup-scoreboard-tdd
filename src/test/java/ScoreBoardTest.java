import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void shouldInitialScoreBeZero() {
        scoreBoard.startGame("Mexico", "Canada");
        var game = scoreBoard.getSummary().getFirst();

        assertAll(
                () -> assertEquals(0, game.getHomeScore()),
                () -> assertEquals(0, game.getAwayScore())
        );
    }

    @Test
    public void shouldThrowExceptionWhenHomeAndAwayTeamsAreTheSame() {
        assertThrows(IllegalArgumentException.class, () -> scoreBoard.startGame("Mexico", "Mexico"));
    }

    @Test
    public void shouldThrowExceptionWhenTeamIsAlreadyPlaying() {
        scoreBoard.startGame("Mexico", "Canada");
        assertThrows(IllegalArgumentException.class, () -> scoreBoard.startGame("England", "Canada"));
    }

    @Test
    public void shouldUpdateScore() {
        scoreBoard.startGame("Mexico", "Canada");
        scoreBoard.updateScore("Mexico", "Canada", 1, 0);
        var game = scoreBoard.getSummary().getFirst();

        assertAll(
                () -> assertEquals(1, game.getHomeScore()),
                () -> assertEquals(0, game.getAwayScore())
        );
    }

    @Test
    public void shouldThrowExceptionWhenScoreIsNegative() {
        scoreBoard.startGame("Mexico", "Canada");
        assertThrows(
                IllegalArgumentException.class,
                () -> scoreBoard.updateScore("Mexico", "Canada", -1, 0));
    }

    @Test
    public void shouldFinishGame() {
        scoreBoard.startGame("Mexico", "Canada");
        scoreBoard.finishGame("Mexico", "Canada");
        assertEquals(0, scoreBoard.getSummary().size());
    }

}
