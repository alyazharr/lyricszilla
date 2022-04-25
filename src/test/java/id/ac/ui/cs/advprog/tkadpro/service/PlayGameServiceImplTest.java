package id.ac.ui.cs.advprog.tkadpro.service;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.model.QuestionInfo;
import id.ac.ui.cs.advprog.tkadpro.repository.GameTypeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PlayGameServiceImplTest {

    @Mock
    private GameTypeRepository gameTypeRepository;

    @InjectMocks
    PlayGameServiceImpl playGameService;


    @Test
    void startGameTest(){

    }

}