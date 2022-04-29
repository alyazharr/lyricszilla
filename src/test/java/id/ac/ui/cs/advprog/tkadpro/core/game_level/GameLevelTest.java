package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GameLevelTest {
    private Class<?> GameLevelClass;
    private GameLevel gameLevel;
    private PlayGame playGame;

    @BeforeEach
    void setUp() throws Exception {
        GameLevelClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.game_level.GameLevel");
        playGame = new PlayGame();
    }

    @Test
    void testGameLevelIsAbstractClass() {
        assertTrue(Modifier.isAbstract(GameLevelClass.getModifiers()));
    }

    @Test
    void testGameTypeHasPlayAbstractMethod() throws Exception {
        Method play = GameLevelClass.getDeclaredMethod("play");
        int methodModifiers = play.getModifiers();

        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, play.getParameterCount());
    }

    @Test
    void testReturnTypePlayAbstractMethod() throws Exception{
        Method play = GameLevelClass.getDeclaredMethod("play");

        assertEquals(String.class, play.getReturnType());
    }

    @Test
    void testGameTypeHasChangeStateAbstractMethod() throws Exception {
        Method changeState = GameLevelClass.getDeclaredMethod("changeState");
        int methodModifiers = changeState.getModifiers();

        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, changeState.getParameterCount());
    }

    @Test
    void testGameTypeHasCheckAnswerConcreteMethod() throws Exception {
        Method checkAnswer = GameLevelClass.getDeclaredMethod("checkAnswer", List.class);
        int methodModifiers = checkAnswer.getModifiers();

        assertFalse(Modifier.isAbstract(methodModifiers));
        assertEquals(1, checkAnswer.getParameterCount());
    }

    @Test
    void testCheckAnswerReturnCorrectValue() {
        gameLevel = new MediumLevelState(playGame);

        List<String> systemAnswer = new ArrayList<>();
        systemAnswer.add("TEST 1");
        systemAnswer.add("TEST 2");
        gameLevel.setAnswers(systemAnswer);

        List<String> userAnswerCorrect = new ArrayList<>();
        userAnswerCorrect.add("TEST 1");
        userAnswerCorrect.add("TEST 2");

        List<String> userAnswerWrong = new ArrayList<>();
        userAnswerWrong.add("TEST 1");
        userAnswerWrong.add("TEST 3");

        var check1 = gameLevel.checkAnswer(userAnswerCorrect);
        var check2 = gameLevel.checkAnswer(userAnswerWrong);

        assertTrue(check1);
        assertFalse(check2);

        gameLevel.setAnswers(Arrays.asList("TEST 3", "TEST 4", "TEST 5"));
        var check3 = gameLevel.checkAnswer(userAnswerWrong);
        assertFalse(check3);
    }

    @Test
    void testGameTypeHasGetNumberOfAnswerConcreteMethod() throws Exception {
        Method getNumberOfAnswer = GameLevelClass.getDeclaredMethod("getNumberOfAnswer");
        int methodModifiers = getNumberOfAnswer.getModifiers();

        assertFalse(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getNumberOfAnswer.getParameterCount());
    }

    @Test
    void testGetNumberOfAnswerReturnCorrectValue() {
        gameLevel = new EasyLevelState(playGame);
        assertEquals(1, gameLevel.getNumberOfAnswer());

        gameLevel = new MediumLevelState(playGame);
        assertEquals(3,gameLevel.getNumberOfAnswer());

        gameLevel = new HardLevelState(playGame);
        assertEquals(5, gameLevel.getNumberOfAnswer());
        gameLevel.setNumOfAnswer(9);
        assertEquals(9, gameLevel.getNumberOfAnswer());
    }

    @Test
    void testToStringReturnCorrectValue() {
        gameLevel = new EasyLevelState(playGame);

        assertEquals("EASY", gameLevel.toString());
    }
}
