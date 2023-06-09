package id.ac.ui.cs.advprog.tkadpro;

import id.ac.ui.cs.advprog.tkadpro.core.game_type.Lyricspatch;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.core.game_type.WordsBlank;
import id.ac.ui.cs.advprog.tkadpro.repository.GameTypeRepository;
import id.ac.ui.cs.advprog.tkadpro.repository.SongRepository;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class GameTypeInitializer {
    @Autowired
    private GameTypeRepository gameTypeRepository;

    @Autowired
    private SongRepository songRepository;

    @PostConstruct
    public void init(){
        //------------------------------ Get Songs From API  (DO NOT TOUCH!) ----------------------------------
        var songURL = "http://musixapi.herokuapp.com/lagu/find";
        var restTemplate = new RestTemplate();
        ResponseEntity<SongDTO[]> responseEntity = restTemplate.getForEntity(songURL,SongDTO[].class);

        SongDTO[] songs = responseEntity.getBody();
        //------------------------------------------------------------------------------------------------------

        assert songs != null;
        songRepository.saveAll(Arrays.asList(songs));

        var wordsBlank = new WordsBlank(songs);
        var lyricspatch = new Lyricspatch(songs);
        // Todo :
        // - Add other gameType into repository

        gameTypeRepository.add(TypeGame.WORDSBLANK, wordsBlank);
        gameTypeRepository.add(TypeGame.LYRICSPATCH, lyricspatch);
    }
}
