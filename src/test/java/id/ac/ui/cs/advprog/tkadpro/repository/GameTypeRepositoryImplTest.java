package id.ac.ui.cs.advprog.tkadpro.repository;

import id.ac.ui.cs.advprog.tkadpro.core.Level;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.GameType;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.Lyricspatch;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameTypeRepositoryImplTest {

    private GameTypeRepositoryImpl gameTypeRepository = new GameTypeRepositoryImpl();

    private SongDTO[] songDTO = new SongDTO[5];

    private GameType dummyGame = new Lyricspatch(songDTO);


    @Test
     void testWhenFindByTypeCalledReturnAppropriateObject() {
        gameTypeRepository.add(TypeGame.WORDSBLANK, dummyGame);

        assertFalse(gameTypeRepository.findByType(TypeGame.WORDSBLANK) == null);
    }

    @Test
     void testWhenFindAllReturnsArray(){
        gameTypeRepository.add(TypeGame.LYRICSPATCH, new Lyricspatch(songDTO));
        gameTypeRepository.add(TypeGame.STARGUESS, new Lyricspatch(songDTO));

        assertEquals(2, gameTypeRepository.findAll().size());

    }

}