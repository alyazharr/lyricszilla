package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.WordsBlank;
import id.ac.ui.cs.advprog.tkadpro.core.modifier.MediumModifier;
import id.ac.ui.cs.advprog.tkadpro.repository.SongRepository;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MediumLevelStateTest {
    private SongDTO[] songDTO = new SongDTO[1];
    private PlayGame playGame = new PlayGame();
    private Class<?> MediumLevelStateClass;
    private MediumLevelState mediumLevelState;

    @Mock
    private SongRepository songRepository;

    @BeforeEach
    void setUp() throws Exception {
        MediumLevelStateClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.game_level.MediumLevelState");
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
        mediumLevelState = new MediumLevelState(playGame);
    }

    @Test
    void testEqualsAttributeValueOnConstructorTest(){
        assertEquals(playGame,mediumLevelState.getPlayGame());
        assertEquals("MEDIUM",mediumLevelState.getLevel());
        assertEquals(3,mediumLevelState.getNumberOfAnswer());
        assertEquals(MediumModifier.class, mediumLevelState.getModifier().getClass());
    }

    @Test
    void testMediumLevelStateOverridePlayMethod() throws Exception {
        Method play = MediumLevelStateClass.getDeclaredMethod("play");

        assertTrue(Modifier.isPublic(play.getModifiers()));
        assertEquals(0, play.getParameterCount());
    }

    @Test
    void testReturnTypeStatementForPlay(){
        mediumLevelState.setGameType(new WordsBlank(songDTO));

        String questions = mediumLevelState.play();

        assertEquals(String.class, questions.getClass());
    }

    @Test
    void testMediumLevelStateOverrideChangeStateMethod() throws Exception {
        Method changeState = MediumLevelStateClass.getDeclaredMethod("changeState");

        assertTrue(Modifier.isPublic(changeState.getModifiers()));
        assertEquals(0, changeState.getParameterCount());
    }

    @Test
    void testChangeState(){
        playGame.setQuestionCounter(11);
        mediumLevelState.changeState();

        assertEquals(HardLevelState.class, playGame.getCurrentState().getClass());
    }

    @Test
    void mediumLevelStateShouldReturnPointsCorrectlyWhenUsingHint() {
        mediumLevelState.setAnswers(Arrays.asList("Hello", "Spring", "Boot!"));
        playGame.setHintCounter(1);
        playGame.setPoints(100);

        mediumLevelState.setGameType(new WordsBlank(songDTO));
        mediumLevelState.useHint(playGame);
        assertEquals(95, playGame.getPoints());

        mediumLevelState.setHintAnswers(Arrays.asList("H", "S", "B"));
        playGame.setHintCounter(2);
        mediumLevelState.useHint(playGame);
        assertEquals(87, playGame.getPoints());

        playGame.setHintCounter(3);
        mediumLevelState.useHint(playGame);
        assertEquals(75, playGame.getPoints());
    }
}
