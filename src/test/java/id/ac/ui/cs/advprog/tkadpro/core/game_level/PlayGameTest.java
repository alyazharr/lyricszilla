package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.Lyricspatch;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.WordsBlank;
import id.ac.ui.cs.advprog.tkadpro.model.HintInfo;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PlayGameTest {
    private PlayGame playGame;
    private Class<?> PlayGameClass;
    private SongDTO[] songDTO = new SongDTO[1];;

    @BeforeEach
    void setUp() throws Exception {
        PlayGameClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.game_level.PlayGame");
        songDTO[0] = new SongDTO("Let Her Go", "Passenger",
                "All the Little Lights", "Well, you only need the light when it's burning low\r\n" +
                "Only miss the sun when it starts to snow\r\n" +
                "Only know you love her when you let her go\r\n" +
                "Only know you've been high when you're feeling low\r\n" +
                "Only hate the road when you're missing home\r\n" +
                "Only know you love her when you let her go\r\n" +
                "And you let her go\r\n" +
                "Staring at the bottom of your glass\r\n" +
                "Hoping one day you'll make a dream last\r\n" +
                "But dreams come slow, and they go so fast\r\n" +
                "You see her when you close your eyes\r\n" +
                "Maybe one day, you'll understand why\r\n" +
                "Everything you touch surely dies\r\n" +
                "But you only need the light when it's burning low\r\n" +
                "Only miss the sun when it starts to snow\r\n" +
                "Only know you love her when you let her go\r\n" +
                "Only know you've been high when you're feeling low\r\n" +
                "Only hate the road when you're missing home\r\n" +
                "Only know you love her when you let her go");
        playGame = new PlayGame();
        playGame.setGameType(new WordsBlank(songDTO));
        playGame.setCurrentState(playGame.getEasyLevelState());
        playGame.setQuestionCounter(1);
        playGame.setHintCounter(1);
    }

    @Test
    void testReturnTypeStatementForPlay(){
        var questions = playGame.play();

        assertEquals(String.class, questions.getClass());
    }

    @Test
    void testPlayIncrementQuestionCounter(){
        var questions = playGame.play();

        assertEquals(2, playGame.getQuestionCounter());
    }

    @Test
    void testReturnTypeStatementForCheckAnswer(){
        List<String> answers = new ArrayList<>();
        answers.add("Testing");

        var questions = playGame.play();
        Boolean check = playGame.checkAnswer(answers);

        assertEquals(Boolean.class, check.getClass());
    }

    @Test
    void testChangeState() {
        playGame.setCurrentState(playGame.getEasyLevelState());
        playGame.setQuestionCounter(4);
        playGame.changeState();
        assertEquals(MediumLevelState.class, playGame.getCurrentState().getClass());

        playGame.setCurrentState(playGame.getMediumLevelState());
        playGame.setQuestionCounter(11);
        playGame.changeState();
        assertEquals(HardLevelState.class, playGame.getCurrentState().getClass());
    }


    @Test
    void testSetGameType(){
        playGame.setGameType(new Lyricspatch(songDTO));
        assertEquals(Lyricspatch.class, playGame.getEasyLevelState().getGameType().getClass());
        assertEquals(Lyricspatch.class, playGame.getMediumLevelState().getGameType().getClass());
        assertEquals(Lyricspatch.class, playGame.getHardLevelState().getGameType().getClass());
    }

    @Test
    void testGetNumberOfAnswerReturnCorrectValue(){
        playGame.setCurrentState(playGame.getEasyLevelState());
        assertEquals(1, playGame.getNumberOfAnswer());

        playGame.setCurrentState(playGame.getMediumLevelState());
        assertEquals(3, playGame.getNumberOfAnswer());

        playGame.setCurrentState(playGame.getHardLevelState());
        assertEquals(5, playGame.getNumberOfAnswer());
    }

    @Test
    void playGameShouldReturnHintInfoCorrectlyWhenUsingHint() {
        playGame.setPoints(100);
        var levelState = playGame.getCurrentState();
        levelState.setAnswers(Arrays.asList("Hello", "Spring", "Boot!"));
        levelState.setHintAnswers(Arrays.asList("H", "S", "B"));
        HintInfo hintInfo = playGame.useHint();

        assertEquals(Arrays.asList("He", "Sp", "Bo"), hintInfo.getHintAnswer());
        assertEquals(2, hintInfo.getNumHint());
        assertEquals(95, hintInfo.getPoint());
    }
}
