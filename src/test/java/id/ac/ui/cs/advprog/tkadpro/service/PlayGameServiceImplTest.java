package id.ac.ui.cs.advprog.tkadpro.service;

import id.ac.ui.cs.advprog.tkadpro.core.game_level.PlayGame;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.model.QuestionInfo;
import id.ac.ui.cs.advprog.tkadpro.repository.GameTypeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayGameServiceImplTest {

    @Mock
    private GameTypeRepository gameTypeRepository;

    @Mock
    private PlayGame playGame = new PlayGame();

    @InjectMocks
    PlayGameServiceImpl playGameService;

    @Mock
    List<String> answer= Arrays.asList("dummy1", "dummy2", "dummy3");

    @Test
    void startGameTest(){
        assertTrue(playGame.getCurrentState() == playGame.getEasyLevelState());
    }

    @Test
    void checkAnswerTest(){
        assertEquals("WRONG", playGame.checkAnswer(answer));
    }



}