package id.ac.ui.cs.advprog.tkadpro;

import id.ac.ui.cs.advprog.tkadpro.core.GameType.TypeGame;
import id.ac.ui.cs.advprog.tkadpro.core.GameType.WordsBlank;
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
        String BASE_URL = "http://musixapi.herokuapp.com/lagu/find";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SongDTO[]> responseEntity = restTemplate.getForEntity(BASE_URL,SongDTO[].class);

        SongDTO[] songs = responseEntity.getBody();
        //------------------------------------------------------------------------------------------------------

        assert songs != null;
        songRepository.saveAll(Arrays.asList(songs));

        var wordsBlank = new WordsBlank(songs);
        // Todo :
        // - Add other gameType into repository

        gameTypeRepository.add(TypeGame.WORDSBLANK, wordsBlank);
    }
}
