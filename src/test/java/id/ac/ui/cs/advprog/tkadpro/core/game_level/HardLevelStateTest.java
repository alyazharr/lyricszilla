package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.WordsBlank;
import id.ac.ui.cs.advprog.tkadpro.core.modifier.HardModifier;
import id.ac.ui.cs.advprog.tkadpro.repository.SongRepository;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HardLevelStateTest {
    private SongDTO[] songDTO = new SongDTO[1];
    private PlayGame playGame = new PlayGame();
    private Class<?> hardLevelStateClass;
    private HardLevelState hardLevelState;

    @Mock
    private SongRepository songRepository;

    @BeforeEach
    public void setUp() throws Exception {
        hardLevelStateClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.game_level.HardLevelState");
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
        hardLevelState = new HardLevelState(playGame);
    }

    @Test
    public void testEqualsAttributeValueOnConstructorTest(){
        assertEquals(playGame,hardLevelState.getPlayGame());
        assertEquals("HARD",hardLevelState.getLevel());
        assertEquals(5,hardLevelState.getNumberOfAnswer());
        assertEquals(HardModifier.class, hardLevelState.getModifier().getClass());
    }

    @Test
    void testHardLevelStateOverridePlayMethod() throws Exception {
        Method play = hardLevelStateClass.getDeclaredMethod("play");

        assertTrue(Modifier.isPublic(play.getModifiers()));
        assertEquals(0, play.getParameterCount());
    }

    @Test
    public void testReturnTypeStatementForPlay(){
        hardLevelState.setGameType(new WordsBlank(songDTO));

        String questions = hardLevelState.play();

        assertEquals(String.class, questions.getClass());
    }

    @Test
    public void testHardLevelStateOverrideChangeStateMethod() throws Exception {
        Method changeState = hardLevelStateClass.getDeclaredMethod("changeState");

        assertTrue(Modifier.isPublic(changeState.getModifiers()));
        assertEquals(0, changeState.getParameterCount());
    }

    @Test
    public void testChangeState(){
        playGame.setQuestionCounter(20);
        hardLevelState.changeState();

        assertEquals(true, playGame.isFinished());
    }
}
