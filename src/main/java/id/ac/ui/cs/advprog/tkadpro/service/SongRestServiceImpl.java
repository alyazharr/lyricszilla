package id.ac.ui.cs.advprog.tkadpro.service;

import id.ac.ui.cs.advprog.tkadpro.core.gametype.Lyricspatch;
import id.ac.ui.cs.advprog.tkadpro.repository.SongRepository;
import id.ac.ui.cs.advprog.tkadpro.rest.SongDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SongRestServiceImpl implements SongRestService{
    private static final String BASE_URL = "http://musixapi.herokuapp.com/lagu/find";
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private SongRepository songRepository;

    @Override
    public SongDTO[] retrieveListSong() {
        ResponseEntity<SongDTO[]> responseEntity = restTemplate.getForEntity(BASE_URL,SongDTO[].class);

        SongDTO[] songs = responseEntity.getBody();

        assert songs != null;
        songRepository.saveAll(Arrays.asList(songs));
//        for (SongDTO song : songs) {
//            System.out.println("Song id: " + song.getId());
//        }
//        var wordsBlank = new WordsBlank(songs);
        var lyricspatch = new Lyricspatch(songs);
        List<String> res = lyricspatch.getHardQnA();
        System.out.println("Question: ");
        System.out.println(res.get(0));
        System.out.println("=============================");
        System.out.println("Answer: ");
        for (int i= 1; i < res.size(); i++) {
            System.out.print(i + " " + res.get(i) + " ");
        }

        return songs;
    }


}
