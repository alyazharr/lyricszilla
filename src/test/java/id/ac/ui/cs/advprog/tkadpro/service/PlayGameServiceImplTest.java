package id.ac.ui.cs.advprog.tkadpro.service;

import id.ac.ui.cs.advprog.tkadpro.GameTypeInitializer;
import id.ac.ui.cs.advprog.tkadpro.core.Level;
import id.ac.ui.cs.advprog.tkadpro.core.game_level.EasyLevelState;
import id.ac.ui.cs.advprog.tkadpro.core.game_level.PlayGame;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.WordsBlank;
import id.ac.ui.cs.advprog.tkadpro.model.QuestionInfo;
import id.ac.ui.cs.advprog.tkadpro.repository.GameTypeRepository;
import id.ac.ui.cs.advprog.tkadpro.repository.GameTypeRepositoryImpl;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayGameServiceImplTest {

    @InjectMocks
    private GameTypeRepository gameTypeRepository = new GameTypeRepositoryImpl();

    @Spy
    private GameTypeInitializer gameTypeInitializer = new GameTypeInitializer();

    private final SongDTO[] songDTO = new SongDTO[1];

    List<String> answers = Arrays.asList("dummy1", "dummy2", "dummy3");

    private Class<?> playGameServiceClass;
    private QuestionInfo questionInfo;
    private GameType wordsBlank;

    @InjectMocks
    private PlayGameService playGameService = new PlayGameServiceImpl();

    @BeforeEach
    public void setup() throws Exception {
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
        wordsBlank = new WordsBlank(songDTO);
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

//    @Test
//    void testStartGame() {
//        gameTypeRepository.add(TypeGame.WORDSBLANK, wordsBlank);
//        when(playGameService.startGame(TypeGame.WORDSBLANK)).thenReturn(questionInfo);
//    }

//    @Test
//    void testCheckAnswer() {
//        String feedback = playGameService.checkAnswer(answers);
//        assertEquals(String.class, feedback);
//    }

}