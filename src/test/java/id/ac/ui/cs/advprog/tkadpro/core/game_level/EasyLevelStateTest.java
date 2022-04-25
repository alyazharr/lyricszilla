package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.WordsBlank;
import id.ac.ui.cs.advprog.tkadpro.core.modifier.EasyModifier;
import id.ac.ui.cs.advprog.tkadpro.repository.SongRepository;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class EasyLevelStateTest {
    private SongDTO[] songDTO = new SongDTO[1];
    private PlayGame playGame = new PlayGame();
    private Class<?> EasyLevelStateClass;
    private EasyLevelState easyLevelState;

    @Mock
    private SongRepository songRepository;

    @BeforeEach
    void setUp() throws Exception {
        EasyLevelStateClass = Class.forName("id.ac.ui.cs.advprog.tkadpro.core.game_level.EasyLevelState");
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
        easyLevelState = new EasyLevelState(playGame);
    }

    @Test
    void testEqualsAttributeValueOnConstructorTest(){
        assertEquals(playGame,easyLevelState.getPlayGame());
        assertEquals("EASY",easyLevelState.getLevel());
        assertEquals(1,easyLevelState.getNumberOfAnswer());
        assertEquals(EasyModifier.class, easyLevelState.getModifier().getClass());
    }

    @Test
    void testEasyLevelStateOverridePlayMethod() throws Exception {
        Method play = EasyLevelStateClass.getDeclaredMethod("play");

        assertTrue(Modifier.isPublic(play.getModifiers()));
        assertEquals(0, play.getParameterCount());
    }

    @Test
    void testReturnTypeStatementForPlay(){
        easyLevelState.setGameType(new WordsBlank(songDTO));

        String questions = easyLevelState.play();

        assertEquals(String.class, questions.getClass());
    }

    @Test
    void testEasyLevelStateOverrideChangeStateMethod() throws Exception {
        Method changeState = EasyLevelStateClass.getDeclaredMethod("changeState");

        assertTrue(Modifier.isPublic(changeState.getModifiers()));
        assertEquals(0, changeState.getParameterCount());
    }

    @Test
    void testChangeState(){
        playGame.setQuestionCounter(4);
        easyLevelState.changeState();

        assertEquals(MediumLevelState.class, playGame.getCurrentState().getClass());
    }
}
