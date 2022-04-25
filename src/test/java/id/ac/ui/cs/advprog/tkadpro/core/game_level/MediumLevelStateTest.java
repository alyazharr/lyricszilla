package id.ac.ui.cs.advprog.tkadpro.core.game_level;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.WordsBlank;
import id.ac.ui.cs.advprog.tkadpro.core.modifier.MediumModifier;
import id.ac.ui.cs.advprog.tkadpro.repository.SongRepository;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;

public class MediumLevelStateTest {
    private PlayGame playGame = new PlayGame();
    private MediumLevelState mediumLevelState;
    
    @Autowired
    private SongRepository songRepository;

    @Test
    public void constructorTest(){
        mediumLevelState = new MediumLevelState(playGame);

        assertEquals(playGame, mediumLevelState.getPlayGame());
        assertEquals("EASY", mediumLevelState.getLevel());
        assertEquals(1, mediumLevelState.getNumberOfAnswer());
        assertEquals(MediumModifier.class, mediumLevelState.getModifier().getClass());
    }

    @Test
    public void playTest(){
        mediumLevelState = new MediumLevelState(playGame);
        
        List<SongDTO> mockListSong = new ArrayList<>();
        mockListSong.add(new SongDTO());

        lenient().when(songRepository.findAll()).thenReturn(mockListSong);
        SongDTO[] songs = new SongDTO[songRepository.findAll().size()];

        songRepository.findAll().toArray(songs);
        mediumLevelState.setGameType(new WordsBlank(songs));

        lenient().when(mediumLevelState.play()).thenReturn("Song lyrics");
        String questions = mediumLevelState.play();

        assertEquals(String.class, questions.getClass());
    }

    @Test
    public void changeStateTest(){
        mediumLevelState = new MediumLevelState(playGame);
        playGame.setQuestionCounter(11);
        mediumLevelState.changeState();

        assertEquals(HardLevelState.class, playGame.getCurrentState().getClass());
    }
}
