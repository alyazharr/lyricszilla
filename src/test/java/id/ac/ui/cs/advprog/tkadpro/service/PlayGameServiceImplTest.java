package id.ac.ui.cs.advprog.tkadpro.service;

import id.ac.ui.cs.advprog.tkadpro.core.game_level.PlayGame;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.WordsBlank;
import id.ac.ui.cs.advprog.tkadpro.model.HintInfo;
import id.ac.ui.cs.advprog.tkadpro.model.QuestionInfo;
import id.ac.ui.cs.advprog.tkadpro.repository.GameTypeRepository;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PlayGameServiceImplTest {

    @Mock
    private GameTypeRepository gameTypeRepository;

    private final SongDTO[] songDTO = new SongDTO[1];

    List<String> dummyAns1 = Arrays.asList("dummy1", "dummy2", "dummy3");
    List<String> dummyAns2 = Arrays.asList("Hello", "Spring", "Boot!");

    private Class<?> playGameServiceClass;
    private PlayGame playGame;

    private PlayGameService playGameService;

    @BeforeEach
    void setup() throws Exception {
        playGameServiceClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.service.PlayGameServiceImpl");
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
        playGameService = new PlayGameServiceImpl();
        playGame = playGameService.getPlayGame();
        playGame.setGameType(new WordsBlank(songDTO));
        playGame.setCurrentState(playGame.getEasyLevelState());
        playGame.setQuestionCounter(1);
        playGame.setHintCounter(1);
        playGame.setPoints(100);
    }

    @Test
    void testPlayGameServiceClassIsConcreteClass() {
        assertFalse(Modifier.isAbstract(playGameServiceClass.getModifiers()));
    }

    @Test
    void testPlayGameServiceImplOverrideStartGameMethod() throws Exception {
        Method startGame = playGameServiceClass.getDeclaredMethod("startGame", TypeGame.class);

        assertEquals(QuestionInfo.class, startGame.getReturnType());
        assertEquals(1, startGame.getParameterCount());
    }

    @Test
    void testPlayGameServiceImplOverrideGenerateQuestionMethod() throws Exception {
        Method startGame = playGameServiceClass.getDeclaredMethod("generateQuestion");

        assertEquals(QuestionInfo.class, startGame.getReturnType());
        assertEquals(0, startGame.getParameterCount());
    }

    @Test
    void testPlayGameServiceImplOverrideCheckAnswerMethod() throws Exception {
        Method startGame = playGameServiceClass.getDeclaredMethod("checkAnswer", List.class);

        assertEquals(String.class, startGame.getReturnType());
        assertEquals(1, startGame.getParameterCount());
    }

    @Test
    void testPlayGameServiceImplOverrideFinishGameMethod() throws Exception {
        Method startGame = playGameServiceClass.getDeclaredMethod("finishGame");

        assertEquals(List.class, startGame.getReturnType());
        assertEquals(0, startGame.getParameterCount());
    }

    @Test
    void testPlayGameServiceImplOverrideGetPlayGame() throws Exception {
        Method getPlayGame = playGameServiceClass.getDeclaredMethod("getPlayGame");

        assertEquals(PlayGame.class, getPlayGame.getReturnType());
        assertEquals(0, getPlayGame.getParameterCount());
    }

    @Test
    void playGameServiceShouldReturnHintInfoCorrectlyWhenUsingHint() {
        var levelState = playGame.getCurrentState();
        levelState.setAnswers(Arrays.asList("Hello", "Spring", "Boot!"));
        levelState.setHintAnswers(Arrays.asList("H", "S", "B"));


        HintInfo hintInfo = playGameService.useHint();

        assertEquals(Arrays.asList("He", "Sp", "Bo"), hintInfo.getHintAnswer());
        assertEquals(2, hintInfo.getNumHint());
        assertEquals(95, hintInfo.getPoint());
    }

    @Test
    void testGenerateQuestionInPlayGameService() {
        playGame.setFinished(false);
        var questionInfo = playGameService.generateQuestion();

        assertEquals(2, questionInfo.getQuestionNumber());
        assertEquals(100, questionInfo.getScore());
        assertEquals(1, questionInfo.getNumberOfAnswer());
        assertEquals("EASY", questionInfo.getLevel());
        assertEquals(100, questionInfo.getHp());
    }

    @Test
    void testCheckAnswerInPlayGameService() {
        var levelState = playGame.getCurrentState();
        levelState.setAnswers(Arrays.asList("Hello", "Spring", "Boot!"));
        levelState.setHintAnswers(Arrays.asList("H", "S", "B"));

        assertEquals("WRONG", playGameService.checkAnswer(dummyAns1));
        assertEquals("CORRECT", playGameService.checkAnswer(dummyAns2));
    }

}
