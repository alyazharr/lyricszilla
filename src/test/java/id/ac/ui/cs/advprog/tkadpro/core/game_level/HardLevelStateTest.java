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

public class HardLevelStateTest {
    private PlayGame playGame = new PlayGame();
    private HardLevelState hardLevelState;

    @Autowired
    private SongRepository songRepository;

    @Test
    public void constructorTest(){
        hardLevelState = new HardLevelState(playGame);

        assertEquals(playGame, hardLevelState.getPlayGame());
        assertEquals("EASY", hardLevelState.getLevel());
        assertEquals(1, hardLevelState.getNumberOfAnswer());
        assertEquals(MediumModifier.class, hardLevelState.getModifier().getClass());
    }

    @Test
    public void playTest(){
        hardLevelState = new HardLevelState(playGame);

        List<SongDTO> mockListSong = new ArrayList<>();
        mockListSong.add(new SongDTO());

        lenient().when(songRepository.findAll()).thenReturn(mockListSong);
        SongDTO[] songs = new SongDTO[songRepository.findAll().size()];

        songRepository.findAll().toArray(songs);
        hardLevelState.setGameType(new WordsBlank(songs));

        lenient().when(hardLevelState.play()).thenReturn("Song lyrics");
        String questions = hardLevelState.play();

        assertEquals(String.class, questions.getClass());
    }

    @Test
    public void changeStateTest(){
        hardLevelState = new HardLevelState(playGame);
        playGame.setQuestionCounter(11);
        hardLevelState.changeState();

        assertEquals(true,playGame.isFinished());
    }
}
