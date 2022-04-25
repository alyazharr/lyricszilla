package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.WordsBlank;
import id.ac.ui.cs.advprog.tkadpro.core.modifier.EasyModifier;
import id.ac.ui.cs.advprog.tkadpro.repository.SongRepository;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;
import org.json.JSONString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EasyLevelStateTest {
    private PlayGame playGame = new PlayGame();
    private EasyLevelState easyLevelState;

    @Mock
    private SongRepository songRepository;

    @Test
    public void constructorTest(){
        easyLevelState = new EasyLevelState(playGame);

        assertEquals(playGame,easyLevelState.getPlayGame());
        assertEquals("EASY",easyLevelState.getLevel());
        assertEquals(1,easyLevelState.getNumberOfAnswer());
        assertEquals(EasyModifier.class, easyLevelState.getModifier().getClass());
    }

    @Test
    public void playTest(){
        easyLevelState = new EasyLevelState(playGame);

        List<SongDTO> mockListSong = new ArrayList<>();
        mockListSong.add(new SongDTO());

        lenient().when(songRepository.findAll()).thenReturn(mockListSong);
        SongDTO[] songs = new SongDTO[songRepository.findAll().size()];

        songRepository.findAll().toArray(songs);
        easyLevelState.setGameType(new WordsBlank(songs));

        when(easyLevelState.play()).thenReturn("Song lyrics");
        String questions = easyLevelState.play();

        assertEquals(String.class, questions.getClass());
    }

    @Test
    public void changeStateTest(){
        easyLevelState = new EasyLevelState(playGame);
        playGame.setQuestionCounter(4);
        easyLevelState.changeState();

        assertEquals(MediumLevelState.class, playGame.getCurrentState().getClass());
    }
}
